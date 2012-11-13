package com.src.collabandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
				// Switching to Team screen
				Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
				startActivity(i);
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