/*package com.src.collabandroid;

import com.src.collabandroid.R;

import android.app.Activity;
import android.os.Bundle;

public class TeamActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
    }
}*/


package com.src.collabandroid;

import static com.src.collabandroid.Constant.FIRST_COLUMN;
import static com.src.collabandroid.Constant.SECOND_COLUMN;
import static com.src.collabandroid.Constant.THIRD_COLUMN;
import static com.src.collabandroid.Constant.FOURTH_COLUMN;
import static com.src.collabandroid.Constant.FIFTH_COLUMN;

 
import java.util.ArrayList;
import java.util.HashMap;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
 

public class TeamActivity extends Activity
{
    private ArrayList<HashMap> list;
 
    public void onCreate(Bundle savedInstanceState)
    { System.out.println("1");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(R.layout.team_layout);

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
            temp.put("Username","Username");
            temp.put("Full Name", "Full Name");
            temp.put("Phone", "Phone");
            temp.put("Email", "Email");
            temp.put("Tasks", "Tasks");

            System.out.println("4");
        list.add(temp);
 
        HashMap temp1 = new HashMap();
        	temp1.put(FIRST_COLUMN,"ericm");
        	temp1.put(SECOND_COLUMN, "Eric Munson");
        	temp1.put(THIRD_COLUMN, "616-555-5555");
        	temp1.put(FOURTH_COLUMN, "ericm@test");
        	temp1.put(FIFTH_COLUMN, "None");
        list.add(temp1);
 
        HashMap temp2 = new HashMap();
        	temp2.put(FIRST_COLUMN,"cam");
        	temp2.put(SECOND_COLUMN, "Cam Warner");
        	temp2.put(THIRD_COLUMN, "616-555-5555");
        	temp2.put(FOURTH_COLUMN, "cam@test");
        	temp2.put(FIFTH_COLUMN, "None");
        list.add(temp2);
 
        HashMap temp3 = new HashMap();
        	temp3.put(FIRST_COLUMN,"erica");
        	temp3.put(SECOND_COLUMN, "Eric Ashley");
        	temp3.put(THIRD_COLUMN, "616-555-5555");
        	temp3.put(FOURTH_COLUMN, "erica@test");
        	temp3.put(FIFTH_COLUMN, "None");
        list.add(temp3);
 
        HashMap temp4 = new HashMap();
        	temp4.put(FIRST_COLUMN,"tommy");
        	temp4.put(SECOND_COLUMN, "Tommy Rankin");
        	temp4.put(THIRD_COLUMN, "616-555-5555");
        	temp4.put(FOURTH_COLUMN, "tommy@test");
        	temp4.put(FIFTH_COLUMN, "None");
        list.add(temp4);
       
        HashMap temp5 = new HashMap();
    		temp5.put(FIRST_COLUMN,"zach");
    		temp5.put(SECOND_COLUMN, "Zach Burnside");
    		temp5.put(THIRD_COLUMN, "616-555-5555");
    		temp5.put(FOURTH_COLUMN, "zach@test");
    		temp5.put(FIFTH_COLUMN, "None");
    	list.add(temp5);
    	
        HashMap temp6 = new HashMap();
    		temp6.put(FIRST_COLUMN,"mike");
    		temp6.put(SECOND_COLUMN, "Mike Vokes");
    		temp6.put(THIRD_COLUMN, "616-555-5555");
    		temp6.put(FOURTH_COLUMN, "mike@test");
    		temp6.put(FIFTH_COLUMN, "None");
    	list.add(temp6);
    }
}