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
import android.widget.ListView;
 

public class TasksActivity extends Activity
{
    private ArrayList<HashMap> list;
 
    public void onCreate(Bundle savedInstanceState)
    { System.out.println("1");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(R.layout.tasks_layout);

        System.out.println("2");
        ListView lview = (ListView) findViewById(R.id.listview);
        populateList();
        System.out.println("5");
        listviewAdapter adapter = new listviewAdapter(this, list);
        lview.setAdapter(adapter);
    }
 
    private void populateList() {
    	System.out.println("3");
        list = new ArrayList<HashMap>();
 
        HashMap temp = new HashMap();
        temp.put("Lead","Lead");
        temp.put("User Story", "User Story");
        temp.put("Task", "Task");
        temp.put("Status", "Status");
        temp.put("Estimated Completion", "Estimated Completion");
        temp.put("Actual Completion", "Actual Completion");


        System.out.println("4");
    list.add(temp);

    HashMap temp1 = new HashMap();
    	temp1.put(FIRST_COLUMN,"ericm");
    	temp1.put(SECOND_COLUMN, "None");
    	temp1.put(THIRD_COLUMN, "Android");
    	temp1.put(FOURTH_COLUMN, "On Track");
    	temp1.put(FIFTH_COLUMN, "11/16/12");
        temp1.put(SIXTH_COLUMN, "TBD");

    list.add(temp1);

    HashMap temp2 = new HashMap();
    	temp2.put(FIRST_COLUMN,"cam");
    	temp2.put(SECOND_COLUMN, "None");
    	temp2.put(THIRD_COLUMN, "Backend");
    	temp2.put(FOURTH_COLUMN, "Good");
    	temp2.put(FIFTH_COLUMN, "11/16/12");
        temp2.put(SIXTH_COLUMN, "TBD");

    list.add(temp2);

    HashMap temp3 = new HashMap();
    	temp3.put(FIRST_COLUMN,"erica");
    	temp3.put(SECOND_COLUMN, "None");
    	temp3.put(THIRD_COLUMN, "GUI");
    	temp3.put(FOURTH_COLUMN, "Good");
    	temp3.put(FIFTH_COLUMN, "11/16/12");
        temp3.put(SIXTH_COLUMN, "TBD");

    list.add(temp3);

    HashMap temp4 = new HashMap();
    	temp4.put(FIRST_COLUMN,"tommy");
    	temp2.put(SECOND_COLUMN, "None");
    	temp4.put(THIRD_COLUMN, "Support/Android");
    	temp4.put(FOURTH_COLUMN, "On Track");
    	temp4.put(FIFTH_COLUMN, "11/16/12");
        temp4.put(SIXTH_COLUMN, "TBD");

    list.add(temp4);
   
    HashMap temp5 = new HashMap();
		temp5.put(FIRST_COLUMN,"zach");
    	temp5.put(SECOND_COLUMN, "None");
		temp5.put(THIRD_COLUMN, "Database");
		temp5.put(FOURTH_COLUMN, "Good");
    	temp5.put(FIFTH_COLUMN, "11/16/12");
        temp5.put(SIXTH_COLUMN, "TBD");

	list.add(temp5);
	
    HashMap temp6 = new HashMap();
		temp6.put(FIRST_COLUMN,"mike");
    	temp6.put(SECOND_COLUMN, "None");
		temp6.put(THIRD_COLUMN, "GCal");
		temp6.put(FOURTH_COLUMN, "Good");
    	temp6.put(FIFTH_COLUMN, "11/16/12");
        temp6.put(SIXTH_COLUMN, "TBD");

	list.add(temp6);
    }
}