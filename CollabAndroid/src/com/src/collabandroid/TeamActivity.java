package com.src.collabandroid;

import static com.src.collabandroid.Constant.FIRST_COLUMN;
import static com.src.collabandroid.Constant.SECOND_COLUMN;
import static com.src.collabandroid.Constant.THIRD_COLUMN;
import static com.src.collabandroid.Constant.FOURTH_COLUMN;
import static com.src.collabandroid.Constant.FIFTH_COLUMN;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TeamActivity extends Activity {
	private ArrayList<HashMap> list;

	public void onCreate(Bundle savedInstanceState) {
		setTitle("Project Tracker: " + ClientBackend.getUser());
		Log.i("Team", "Project Tracker: " + ClientBackend.getUser());

		super.onCreate(savedInstanceState);

		getParent().setTitle("Project Tracker: " + ClientBackend.getName());
		Log.i("Team2", "Project Tracker: " + ClientBackend.getUser());

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout layoutText = new LinearLayout(this);
		layoutText = (LinearLayout) View.inflate(this, R.layout.labels, null);

		LinearLayout layoutButton = new LinearLayout(this);
		layoutButton = (LinearLayout) View
				.inflate(this, R.layout.buttons, null);

		View button = layoutButton.findViewById(R.id.btnProjects);

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(),
						ProjectsActivity.class);
				startActivity(i);
			}
		});

		TableLayout table = new TableLayout(this);
		table.setStretchAllColumns(true);
		table.setShrinkAllColumns(true);
		createTeamRows(table);
		Log.i("Team6", "Project Tracker: " + ClientBackend.getUser());

		layout.addView(layoutText);
		layout.addView(layoutButton);
		layout.addView(table);
		setContentView(layout);

	}

	private void createTeamRows(TableLayout table) {
		System.out.println("Creating team rows");
		TableRow titleRow = new TableRow(this);
		TextView userName = new TextView(this);
		userName.setText("UserName");
		TextView phone = new TextView(this);
		phone.setText("Phone");
		TextView email = new TextView(this);
		email.setText("Email");
		TextView task = new TextView(this);
		task.setText("Tasks");
		titleRow.addView(userName);
		titleRow.addView(phone);
		titleRow.addView(email);
		titleRow.addView(task);
		table.addView(titleRow);

		String[][] userTableData = ClientBackend.getBackend().getUserTableData(
				ClientBackend.getProj());
		System.out.println("Got team data");
		for (String[] user : userTableData) {
			TableRow teamRow = new TableRow(this);
			for (String str : user) {
				TextView view = new TextView(this);
				int index = str.indexOf("(click");
				if (index > 0) {
					str = str.substring(0, index);
				}
				view.setText(str);
				teamRow.addView(view);
			}
			table.addView(teamRow);
		}
	}
}