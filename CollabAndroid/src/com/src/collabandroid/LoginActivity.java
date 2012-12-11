package com.src.collabandroid;

import collaborationjava7.common.Backend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
        TextView loginButton = (TextView) findViewById(R.id.btnLogin);
        
        
        
		// Listening to login button
        loginButton.setOnClickListener(new View.OnClickListener() {

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
				Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
				startActivity(i);
				}
			}
		});

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
	
			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
    }
}