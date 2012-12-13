package com.src.collabandroid;

import collaborationjava7.common.Backend;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InvalidActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.i("Invalid", "invlaid starting");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.invalid);

		TextView returnButton = (TextView) findViewById(R.id.btnReturn);

		// Listening to login button
		returnButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				// Switching to Team screen
				Log.i("Invalid", "leaving invalid");

				Intent i = new Intent(getApplicationContext(),
						LoginActivity.class);
				startActivity(i);

			}
		});
	}
}