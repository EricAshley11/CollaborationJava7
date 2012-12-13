package com.src.collabandroid;

import com.src.collabandroid.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.util.Log;

public class CollabAndroidActivity extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();
		System.out.println("0");
		// Tab for Team
		TabSpec teamSpec = tabHost.newTabSpec("Team");
		System.out.println("01");

		teamSpec.setIndicator("Team",
				getResources().getDrawable(R.drawable.icon_team_tab));
		System.out.println("02");

		Intent teamIntent = new Intent(this, TeamActivity.class);// MultiColumnActivity.class);//TeamActivity.class);
		System.out.println("03");

		teamSpec.setContent(teamIntent);
		System.out.println("04");

		// Tab for Tasks
		TabSpec taskSpec = tabHost.newTabSpec("Task");
		taskSpec.setIndicator("Task",
				getResources().getDrawable(R.drawable.icon_tasks_tab));
		Intent taskIntent = new Intent(this, TasksActivity.class);
		taskSpec.setContent(taskIntent);

		/*
		 * // Tab for Calendar TabSpec calSpec = tabHost.newTabSpec("Calendar");
		 * calSpec.setIndicator("Calendar",
		 * getResources().getDrawable(R.drawable.icon_cal_tab)); Intent
		 * calIntent = new Intent(this, CalActivity.class);
		 * calSpec.setContent(calIntent);
		 * 
		 * // Tab for Graph TabSpec graphSpec = tabHost.newTabSpec("Graphs");
		 * graphSpec.setIndicator("Graphs",
		 * getResources().getDrawable(R.drawable.icon_graph_tab)); Intent
		 * graphIntent = new Intent(this, GraphActivity.class);
		 * graphSpec.setContent(graphIntent);
		 */

		// Adding all TabSpec to TabHost
		System.out.println("06");

		tabHost.addTab(teamSpec); // Adding Team tab
		System.out.println("07");

		tabHost.addTab(taskSpec); // Adding Tasks tab
		/*
		 * tabHost.addTab(calSpec); // Adding Calendar tab
		 * tabHost.addTab(graphSpec); // Adding Graph tab
		 */// tabHost.setOnTabChangedListener(this);
			// tabHost.clearAllTabs();

	}

	public void onTabChanged(String tabId) {
		System.out.println();
		Log.i("Tab Changed", "tabId = " + tabId);

	}
}