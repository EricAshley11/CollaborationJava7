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
				
				EditText name = (EditText)findViewById(R.id.txtName);
		        String nameStr = name.getText().toString();
		        System.out.println(nameStr);
		        EditText pass = (EditText)findViewById(R.id.txtPass);
		        String passStr = pass.getText().toString();
				System.out.println(passStr);
				
				/*Backend backend = */ClientBackend.newBackend();//(nameStr, passStr);
				
				if (!nameStr.matches("") &&ClientBackend.validCredentials(nameStr,passStr)){
					//Log.i("Login", "validate = "+ClientBackend.validCredentials(nameStr,passStr));

					//if(ClientBackend.validCredentials(nameStr,passStr)) {
				
						// Switching to Team screen
						Log.i("Login", "Logging in user");

						Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
						startActivity(i);
					
				}//}
				else{
					Log.i("Login", "invlaid user: "); //+ClientBackend.validCredentials(nameStr,passStr));
					Intent i = new Intent(getApplicationContext(), InvalidActivity.class);
					startActivity(i);
				}
				
				
				
				/*if(ClientBackend.getUser()==null){
					Log.i("Login", "invlaid user");
					Intent i = new Intent(getApplicationContext(), InvalidActivity.class);
					startActivity(i);
					Point p = null;
					p.x=10;
				    p.y=10;
					showPopup(LoginActivity.this, p);
					
				} else{
					Log.i("Login", "Logging in user");

				// Switching to Team screen
				Intent i = new Intent(getApplicationContext(), CollabAndroidActivity.class);
				startActivity(i);
				}*/
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
    
    
    
    
    
/*    private void showPopup(final Activity context, Point p) {
    	
    	   int popupWidth = 200;
    	
    	   int popupHeight = 150;
    	
    	 
    	
    	   // Inflate the popup_layout.xml
    	
    	   LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.btnReturn);
    	
    	   LayoutInflater layoutInflater = (LayoutInflater) context
    	
    	     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    	   View layout = layoutInflater.inflate(R.layout.invalid, viewGroup);
    	
    	 
    	
    	   // Creating the PopupWindow
    	
    	   final PopupWindow popup = new PopupWindow(context);
    	
    	   popup.setContentView(layout);
    	
    	   popup.setWidth(popupWidth);
    	
    	   popup.setHeight(popupHeight);
    	
    	   popup.setFocusable(true);
    	
    	 
    	
    	   // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
    	
    	   int OFFSET_X = 30;
    	
    	   int OFFSET_Y = 30;
    	
    	 
    	
    	  // Clear the default translucent background
    	
    	   popup.setBackgroundDrawable(new BitmapDrawable());
    	
    
    	
    	   // Displaying the popup at the specified location, + offsets.
    	
    	   popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);
    	
    	 
    	
    	   // Getting a reference to Close button, and close the popup when clicked.
    	
    	   Button close = (Button) layout.findViewById(R.id.btnReturn);
    	
    	   close.setOnClickListener(new View.OnClickListener() {
    	
    	 
    	//@Overide
    	     public void onClick(View v) {
    	
    	       popup.dismiss();
    	
    	     }
    	
    	   });
    	
    	}

    */
}