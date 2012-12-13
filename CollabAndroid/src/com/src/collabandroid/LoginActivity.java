package com.src.collabandroid;

import collaborationjava7.common.Backend;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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

				EditText name = (EditText) findViewById(R.id.txtName);
				String nameStr = name.getText().toString();
				System.out.println(nameStr);
				EditText pass = (EditText) findViewById(R.id.txtPass);
				String passStr = pass.getText().toString();
				System.out.println(passStr);

				ClientBackend.newBackend();

				if (!nameStr.matches("")
						&& ClientBackend.validCredentials(nameStr, passStr)) {
					Log.i("Login", "Logging in user");

					Intent i = new Intent(getApplicationContext(),
							CollabAndroidActivity.class);
					startActivity(i);

				} else {
					Log.i("Login", "invlaid user: ");
					Intent i = new Intent(getApplicationContext(),
							InvalidActivity.class);
					startActivity(i);
				}
			}
		});

		// Listening to register new account link
		registerScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
			}
		});
	}

}