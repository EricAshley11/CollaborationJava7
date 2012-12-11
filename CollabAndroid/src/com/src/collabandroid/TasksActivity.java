/*package com.src.collabandroid;

import com.src.collabandroid.R;

import android.app.Activity;
import android.os.Bundle;

public class TasksActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);
    }
}*/


package com.src.collabandroid;

import static com.src.collabandroid.Constant.FIRST_COLUMN;
import static com.src.collabandroid.Constant.SECOND_COLUMN;
import static com.src.collabandroid.Constant.THIRD_COLUMN;
import static com.src.collabandroid.Constant.FOURTH_COLUMN;
import static com.src.collabandroid.Constant.FIFTH_COLUMN;
import static com.src.collabandroid.Constant.SIXTH_COLUMN;

 
import java.util.ArrayList;
import java.util.HashMap;
 
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
 

public class TasksActivity extends Activity
{
    private ArrayList<HashMap> list;
 
    public void onCreate(Bundle savedInstanceState)
    { setTitle("Project Tracker: "+ClientBackend.getUser());
    	Log.i("Tasks","Project Tracker: "+ClientBackend.getUser());

    	
    	System.out.println("1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);

        getParent().setTitle("Project Tracker: "+ClientBackend.getName());
    	Log.i("Tasks2","Project Tracker: "+ClientBackend.getUser());
    	
    	
        TableLayout table = new TableLayout(this);
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);
        createTaskRows(table); 
        setContentView(table);
    }
 
    private void createTaskRows(TableLayout table) {
    	System.out.println("Creating task rows");
    	TableRow titleRow = new TableRow(this);
    	TextView lead = new TextView(this);
    	lead.setText("Lead");
    	titleRow.addView(lead);
    	TextView userStory = new TextView(this);
    	userStory.setText("UserStory");
    	titleRow.addView(userStory);
    	TextView task = new TextView(this);
    	task.setText("Task");
    	titleRow.addView(task);
    	TextView status = new TextView(this);
    	status.setText("Status");
    	titleRow.addView(status);
    	TextView estimated = new TextView(this);
    	estimated.setText("Estimated");
    	titleRow.addView(estimated);
    	TextView actual = new TextView(this);
    	actual.setText("Actual");
    	titleRow.addView(actual);
    	table.addView(titleRow);
    	
    	String[][] taskData = ClientBackend.getBackend().getTasksTableData(ClientBackend.getProj());
    	for(String[] taskRow : taskData){
    		TableRow newRow = new TableRow(this);
    		for(String data : taskRow){
    			TextView view = new TextView(this);
    			view.setText(data);
    			newRow.addView(view);
    		}
    		table.addView(newRow);
    	}
    }
}