package com.src.collabandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        TextView loginButton = (TextView) findViewById(R.id.btnRegister);
        
		// Listening to Register New Account button
        loginButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to Team screen
				Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
				startActivity(i);
			}
		});
        
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// Switching to Login Screen/closing register screen
				finish();
				//Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				//startActivity(i);
			}
		});
    }
}