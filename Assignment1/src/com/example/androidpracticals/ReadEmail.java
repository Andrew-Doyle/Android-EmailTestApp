package com.example.androidpracticals;



import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


//Using ActionBar Sherlock to allow the use of ActionBar in all android versions
public class ReadEmail extends SherlockActivity  implements OnKeyListener, OnClickListener{

	
	ImageButton backButton, newButton;
	Button clearForm, sendForm;
	EditText edittext, edittext2, edittext3, edittext4, edittext5, edittext6;
	TextView textviewcontent1, textviewcontent2, textviewcontent3,
			textviewcontent4, textviewcontent5;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
        /* Setting color to white below - I don`t know why 
         * - but there are grey bits otherwise on s3 phone (but not Nexus 7 tablet) !! */
        
        View backgroundWhite = findViewById(R.id.rootLayout);
        View root = backgroundWhite.getRootView();
        root.setBackgroundColor(getResources().getColor(android.R.color.white));

		/*
		 * Reads the strings from the intent into the TextView - 
		 */
		textviewcontent1 = (TextView) findViewById(R.id.textviewcontent1);
		textviewcontent1
				.setText(getIntent().getExtras().getString("editText1"));
		textviewcontent2 = (TextView) findViewById(R.id.textviewcontent2);
		textviewcontent2
				.setText(getIntent().getExtras().getString("editText2"));
		textviewcontent3 = (TextView) findViewById(R.id.textviewcontent3);
		textviewcontent3
				.setText(getIntent().getExtras().getString("editText3"));
		textviewcontent4 = (TextView) findViewById(R.id.textviewcontent4);
		textviewcontent4
				.setText(getIntent().getExtras().getString("editText5"));
		textviewcontent5 = (TextView) findViewById(R.id.textviewcontent5);
		
		textviewcontent5
				.setText(getIntent().getExtras().getString("editText6"));
	
		/* Back and new Button Images  - ABANDONED IN FAVOUR of the ActionBar*/
//		newButton = (ImageButton) findViewById(R.id.button3);
//		backButton = (ImageButton) findViewById(R.id.button4);
//
//				
//		backButton.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//								
//				return_to_composition(v);
//			}
//		});
//
//
//		/* the listener for the New Email Button */
//		newButton.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent sendEmail = new Intent();
//				sendEmail.setClassName("com.example.androidpracticals",
//						"com.example.androidpracticals.MainActivity");
//				startActivity(sendEmail);
//			}
//		});

	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    new MenuInflater(this).inflate(R.menu.options_read_mail, menu);
    
    return(super.onCreateOptionsMenu(menu));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
    
    return(true);
    case R.id.about:
    openAbout();
    return(true);
    case R.id.feedback:
    openFeedback();
    return(true);
    case R.id.go_back:
    onBackPressed();    	
    return(true);
    case R.id.new_email:
    newEmail();
    return(true);

    }
    return(super.onOptionsItemSelected(item));
    }
   
    /*Method to open feedback page from actionbar/options menu*/
    private void openFeedback(){
    	Intent intent = new Intent();
    	intent.setClassName("com.example.androidpracticals","com.example.androidpracticals.FeedbackForm");
    	startActivity(intent);
    }
    
    /*Method to open about page from actionbar/options menu*/
    private void openAbout(){
    	Intent intent = new Intent();
    	intent.setClassName("com.example.androidpracticals","com.example.androidpracticals.About");
    	startActivity(intent);
    }      
    
    /*Method to go to composition email activity from actionbar/options menu*/
    private void newEmail(){
		Intent sendEmail = new Intent();
		sendEmail.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.MainActivity");
		startActivity(sendEmail);
    }
    
    public void return_to_composition(View v) {
		finish();
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}


