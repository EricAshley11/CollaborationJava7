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


public class ProjectsActivity extends Activity/* implements View.OnClickListener*/ {
	
	private ArrayList<Project> projectList;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
		Log.i("Invalid", "invlaid starting");

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.invalid);
        
       // TextView returnButton = (TextView) findViewById(R.id.btnReturn);
       // TextView loginButton = (TextView) findViewById(R.id.btnLogin);
        /*User user = ClientBackend.getUser();
        Backend backend =ClientBackend.getBackend();
        ArrayList<Project> projects = backend.retrieveProjects(user);
        for (Project project : projects) {
            //projectComboBox.addItem(project);
        }*/
        
        
        
        TableLayout table = new TableLayout(this);
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);
       // createProjectRows(table); 
        
        
        
        
        
        
        
        
        
        
        
        
      //LinearLayout teamsLayout = (LinearLayout)findViewById(R.layout.login);
    	System.out.println("Creating project rows");
        TableRow titleRow = new TableRow(this);
        TextView projectName = new TextView(this);
        projectName.setText("Project Name");
        /*TextView phone = new TextView(this);
        phone.setText("Phone");
        TextView email = new TextView(this);
        email.setText("Email");
        TextView task = new TextView(this);
        task.setText("Tasks");*/
        titleRow.addView(projectName);
        /*titleRow.addView(phone);
        titleRow.addView(email);
        titleRow.addView(task);*/
        table.addView(titleRow);
        
        
		User user = ClientBackend.getUser();
		Backend backend = ClientBackend.getBackend();
		/*ArrayList<Project> */projectList = backend.retrieveProjects(user);
		Log.i("Projects", "got projects");
		int count = 0;
		//projects.
		for (Project project : projectList) {
			// projectComboBox.addItem(project);
			Log.i("Projects", "project = " + project);
			TableRow projectRow = new TableRow(this);
			Button button = new Button(this);
			button.setText(project + "");
			button.setId(count);
			count++;

			/*
			 * buyButton.setLayoutParams(new LayoutParams(
			 * ViewGroup.LayoutParams.WRAP_CONTENT,
			 * ViewGroup.LayoutParams.WRAP_CONTENT));
			 */
			button.setOnClickListener(handleOnClick(button));
			projectRow.addView(button);
			/*
			 * //for(String str : user){ TextView view = new TextView(this);
			 * 
			 * 
			 * int index = str.indexOf("(click"); if(index > 0){ str =
			 * str.substring(0, index); } view.setText(str);
			 */
			//projectRow.addView(view);
			// }
            table.addView(projectRow);
    	
        }
        
		setContentView(table);
        /*
    	String[][] userTableData = ClientBackend.getBackend().getUserTableData(ClientBackend.getProj());
    	System.out.println("Got team data");
    	for(String[] user : userTableData){
        	TableRow teamRow = new TableRow(this);
            for(String str : user){
            	TextView view = new TextView(this);
            	int index = str.indexOf("(click");
            	if(index > 0){
            		str = str.substring(0, index);
            	}
            	view.setText(str);
            	teamRow.addView(view);
            }
            table.addView(teamRow);
    	}*/
        
        
        
        
        
        
        
        
        
        
        
        
       
        ///layout.addView(table);
        
        
		// Listening to login button
/*        button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				EditText name = (EditText)findViewById(R.id.txtName);
		        String nameStr = name.getText().toString();
		        System.out.println(nameStr);
		        EditText pass = (EditText)findViewById(R.id.txtPass);
		        String passStr = pass.getText().toString();
				System.out.println(passStr);
				
				Backend backend = ClientBackend.newBackend(nameStr, passStr);
				
				
				if(backend==null){
					Log.i("Login", "invlaid user");
					name.setText("Username or password incorrect", TextView.BufferType.EDITABLE);
					pass.setText("", TextView.BufferType.EDITABLE);
				} else{
					Log.i("Login", "Logging in user");

				// Switching to Team screen
				Log.i("Invalid", "leaving invalid");

				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				//}
			}
		});*/

     /*   // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
	
			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}*/
		//});
    }
    
    
    
    
    
    
    
    
    
    
    
    
    View.OnClickListener handleOnClick(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
            	ClientBackend.setProj(projectList.get(button.getId()));
            	Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
				startActivity(i);
            }
        };
    }
    
    
    
    
    
    
    
    
    
    private void createProjectRows(TableLayout table){
    	//LinearLayout teamsLayout = (LinearLayout)findViewById(R.layout.login);
    	System.out.println("Creating team rows");
        TableRow titleRow = new TableRow(this);
        TextView projectName = new TextView(this);
        projectName.setText("UserName");
        /*TextView phone = new TextView(this);
        phone.setText("Phone");
        TextView email = new TextView(this);
        email.setText("Email");
        TextView task = new TextView(this);
        task.setText("Tasks");*/
        titleRow.addView(projectName);
        /*titleRow.addView(phone);
        titleRow.addView(email);
        titleRow.addView(task);*/
        table.addView(titleRow);
        
        
		User user = ClientBackend.getUser();
		Backend backend = ClientBackend.getBackend();
		ArrayList<Project> projects = backend.retrieveProjects(user);
		Log.i("Projects", "got projects");
		int count = 0;
		//projects.
		for (Project project : projects) {
			// projectComboBox.addItem(project);
			Log.i("Projects", "project = " + project);
			TableRow projectRow = new TableRow(this);
			Button button = new Button(this);
			button.setText(project + "");
			button.setId(count);

			/*
			 * buyButton.setLayoutParams(new LayoutParams(
			 * ViewGroup.LayoutParams.WRAP_CONTENT,
			 * ViewGroup.LayoutParams.WRAP_CONTENT));
			 */
			//button.setOnClickListener(new View.OnClickListener() 
			projectRow.addView(button);
			/*
			 * //for(String str : user){ TextView view = new TextView(this);
			 * 
			 * 
			 * int index = str.indexOf("(click"); if(index > 0){ str =
			 * str.substring(0, index); } view.setText(str);
			 */
			//projectRow.addView(view);
			// }
            table.addView(projectRow);
    	
        }
        
        
        
    /*	String[][] userTableData = ClientBackend.getBackend().getUserTableData(ClientBackend.getProj());
    	System.out.println("Got team data");
    	for(String[] user : userTableData){
        	TableRow teamRow = new TableRow(this);
            for(String str : user){
            	TextView view = new TextView(this);
            	int index = str.indexOf("(click");
            	if(index > 0){
            		str = str.substring(0, index);
            	}
            	view.setText(str);
            	teamRow.addView(view);
            }
            table.addView(teamRow);
    	}*/
    }
}