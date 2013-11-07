package com.example.androidpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class FeedbackForm extends SherlockActivity {
	
/*	TextView textViewA, textViewB;
	RadioGroup suggestion, reportProblem;*/
	ImageButton clearForm, sendForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* stops keybord from automatically popping up */
       // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); 
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /* Setting color to white below - I don`t know why - but there are grey bits otherwise on s3 phone (but not Nexus 7 tablet) !! */
        
        View backgroundWhite = findViewById(R.id.rootLayout);
        View root = backgroundWhite.getRootView();
        root.setBackgroundColor(getResources().getColor(android.R.color.white));
        
              
//        /* BUTTONS ABANDONED IN FAVOUR OF ACTION BAR
//        final EditText name = (EditText) findViewById(R.id.editText1);
//        final EditText mailaddress = (EditText) findViewById(R.id.editText2);
//        final EditText comment = (EditText) findViewById(R.id.editText3);
//        clearForm = (ImageButton) findViewById(R.id.button3);
//        sendForm = (ImageButton) findViewById(R.id.button4);
//        clearForm.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
//			    clearForm(group);
//				
//			}
//		});
//        
//        sendForm.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent email = new Intent(android.content.Intent.ACTION_SEND);
//				email.setType("plain/text");
//	            email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"andrew.doyle@ucdconnect.ie",mailaddress.getText().toString()});
//	            email.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pigeon Mail Feedback Form");
//	            email.putExtra(android.content.Intent.EXTRA_TEXT, "Name: "+name.getText().toString()+'\n'+"Email Address: "+mailaddress.getText().toString()+'\n'+"Comment: "+comment.getText().toString()+'\n'+'\n'+"Sent from the Pigeon Mail Android App.");
//
//	            /* Send it off to the Activity-Chooser */
//	            startActivity(Intent.createChooser(email, "Send mail..."));
//			}
//		});  */
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    new MenuInflater(this).inflate(R.menu.options_feedback, menu);
    
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
    case R.id.send_email:
    sendMail();
    return(true);
    case R.id.go_back:
    onBackPressed();
    return(true);
    case R.id.new_email:
    newEmail();
    return(true);
	case R.id.cancel:
	clearText();
	return (true);
    }
    return(super.onOptionsItemSelected(item));
    }
   
    
    /*Method to open about page from options menu*/
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
    
    /*Method to clear text from actionbar/options menu*/
    private void clearText(){
    	ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
		clearForm(group);
    }
    
    /*Method to send feedback from actionbar/options menu*/
    private void sendMail(){
        final EditText name = (EditText) findViewById(R.id.editText1);
        final EditText mailaddress = (EditText) findViewById(R.id.editText2);
        final EditText comment = (EditText) findViewById(R.id.editText3);
        
		Intent email2 = new Intent(android.content.Intent.ACTION_SEND);
		email2.setType("plain/text");
        email2.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"andrew.doyle@ucdconnect.ie",mailaddress.getText().toString()});
        email2.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pigeon Mail Feedback Form");
        email2.putExtra(android.content.Intent.EXTRA_TEXT, "Name: "+name.getText().toString()+'\n'+"Email Address: "+mailaddress.getText().toString()+'\n'+"Comment: "+comment.getText().toString()+'\n'+'\n'+"Sent from the Pigeon Mail Android App.");

        /* Send it off to the Activity-Chooser */
        startActivity(Intent.createChooser(email2, "Send mail..."));
    }
    
    
	/*ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
    clearForm(group);*/
    
    private void clearForm(ViewGroup group)
    {       
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
        View view = group.getChildAt(i);
        if (view instanceof EditText) {
            ((EditText)view).setText("");
        }

        if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
            clearForm((ViewGroup)view);
    }
    }
    
}
