package com.src.collabandroid;

import com.src.collabandroid.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class CollabAndroidActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabHost = getTabHost();
        
        // Tab for Team
        TabSpec teamSpec = tabHost.newTabSpec("Team");
        teamSpec.setIndicator("Team", getResources().getDrawable(R.drawable.icon_team_tab));
        Intent teamIntent = new Intent(this, TeamActivity.class);
        teamSpec.setContent(teamIntent);
        
        // Tab for Tasks
        TabSpec taskSpec = tabHost.newTabSpec("Task");
        taskSpec.setIndicator("Task", getResources().getDrawable(R.drawable.icon_tasks_tab));
        Intent taskIntent = new Intent(this, TasksActivity.class);
        taskSpec.setContent(taskIntent);
        
        // Tab for Calendar
        TabSpec calSpec = tabHost.newTabSpec("Calendar");
        calSpec.setIndicator("Calendar", getResources().getDrawable(R.drawable.icon_cal_tab));
        Intent calIntent = new Intent(this, CalActivity.class);
        calSpec.setContent(calIntent);
        
        // Tab for Graph
        TabSpec graphSpec = tabHost.newTabSpec("Graphs");
        graphSpec.setIndicator("Graphs", getResources().getDrawable(R.drawable.icon_graph_tab));
        Intent graphIntent = new Intent(this, GraphActivity.class);
        graphSpec.setContent(graphIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(teamSpec); // Adding Team tab
        tabHost.addTab(taskSpec); // Adding Tasks tab
        tabHost.addTab(calSpec); // Adding Calendar tab
        tabHost.addTab(graphSpec); // Adding Graph tab

    }
}