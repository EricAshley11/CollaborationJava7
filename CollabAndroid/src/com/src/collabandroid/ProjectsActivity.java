package com.src.collabandroid;

import java.util.ArrayList;

import collaborationjava7.common.Backend;
import collaborationjava7.common.Project;
import collaborationjava7.common.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ProjectsActivity extends Activity {

	private ArrayList<Project> projectList;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.i("Invalid", "invlaid starting");

		super.onCreate(savedInstanceState);

		TableLayout table = new TableLayout(this);
		table.setStretchAllColumns(true);
		table.setShrinkAllColumns(true);

		System.out.println("Creating project rows");
		TableRow titleRow = new TableRow(this);
		TextView projectName = new TextView(this);
		projectName.setText("Project Name");

		titleRow.addView(projectName);

		table.addView(titleRow);

		User user = ClientBackend.getUser();
		Backend backend = ClientBackend.getBackend();
		projectList = backend.retrieveProjects(user);
		Log.i("Projects", "got projects");
		int count = 0;
		for (Project project : projectList) {
			Log.i("Projects", "project = " + project);
			TableRow projectRow = new TableRow(this);
			Button button = new Button(this);
			button.setText(project + "");
			button.setId(count);
			count++;

			button.setOnClickListener(handleOnClick(button));
			projectRow.addView(button);

			table.addView(projectRow);

		}

		setContentView(table);

	}

	View.OnClickListener handleOnClick(final Button button) {
		return new View.OnClickListener() {
			public void onClick(View v) {
				ClientBackend.setProj(projectList.get(button.getId()));
				Intent i = new Intent(getApplicationContext(),
						CollabAndroidActivity.class);
				startActivity(i);
			}
		};
	}

}