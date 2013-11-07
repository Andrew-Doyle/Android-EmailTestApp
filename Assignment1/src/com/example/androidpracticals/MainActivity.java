package com.example.androidpracticals;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

// Using ActionBar Sherlock to allow the use of ActionBar in all android versions
public class MainActivity extends SherlockActivity implements OnKeyListener,
		OnClickListener {

	ImageButton clearForm, sendForm, add;
	EditText edittext, edittext2, edittext3, edittext4, edittext5, edittext6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		/* SAVING STATE INFORMATION BELOW */

//		if (savedInstanceState != null) {
//			onSaveInstanceState(savedInstanceState);
//			super.onRestoreInstanceState(savedInstanceState);
//		}

		/*
		 * stops keybord from automatically popping up - disabled this feature
		 * for now getWindow().setSoftInputMode(
		 * WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); /
		 * 
		 * /* could hide the app name and logo like this:
		 * getSupportActionBar().setHomeButtonEnabled(false);
		 * getSupportActionBar().setDisplayShowTitleEnabled(false);
		 * getSupportActionBar().setDisplayShowHomeEnabled(false);
		 */

		setContentView(R.layout.activity_composition);

		/*
		 * Setting color to white below - I don`t know why - but there are grey
		 * bits otherwise on s3 phone (but not Nexus 7 tablet) !!
		 */

		View backgroundWhite = findViewById(R.id.rootLayout);
		View root = backgroundWhite.getRootView();
		root.setBackgroundColor(getResources().getColor(android.R.color.white));

		/*
		 * Using ActionBar instead of Buttons clearForm = (ImageButton)
		 * findViewById(R.id.button3); sendForm = (ImageButton)
		 * findViewById(R.id.button4);
		 */
		edittext = (EditText) findViewById(R.id.editText1); // From

		edittext.setOnKeyListener(this); // still need this?
		edittext2 = (EditText) findViewById(R.id.editText2); // To
		edittext3 = (EditText) findViewById(R.id.editText3); // cc
		edittext4 = (EditText) findViewById(R.id.editText4); // bcc
		edittext5 = (EditText) findViewById(R.id.editText5); // Subject
		edittext6 = (EditText) findViewById(R.id.editText6); // Email Body

		/*
		 * The below sets default text for the email body (helps promote the
		 * application)
		 */
		String sentFromPigeon = "\n\n\nSent from Pigeon Mail for Android";
		edittext6.setText(sentFromPigeon);
		
		/*
		 * Using ActionBar instead of Buttons // 
		 * ABANDONED IN FAVOUR of the ActionBar/
		 * /* the listener for the Clear
		 * Button
		 *
		  clearForm.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
		// clearForm(group);
		//
		// }
		// });
		//
		// /* the listener for the Send Button */
		// sendForm.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Intent sentEmail = new Intent();
		// sentEmail.setClassName("com.example.androidpracticals",
		// "com.example.androidpracticals.ReadEmail");
		// /*
		// * reads all the editText information and adds it to the intent
		// * -
		// */
		// String from = edittext.getText().toString();
		// sentEmail.putExtra("editText1", from);
		// String to = edittext2.getText().toString();
		// sentEmail.putExtra("editText2", to);
		// String cc = edittext3.getText().toString();
		// sentEmail.putExtra("editText3", cc);
		// String bcc = edittext5.getText().toString();
		// sentEmail.putExtra("editText5", bcc);
		// String subject = edittext6.getText().toString();
		// sentEmail.putExtra("editText6", subject);
		//
		// startActivity(sentEmail);
		//
		// }
		// });

		Foo test = new Foo();

		edittext.setOnFocusChangeListener(test);
		edittext2.setOnFocusChangeListener(test);
		edittext3.setOnFocusChangeListener(test);
		edittext4.setOnFocusChangeListener(test);

	}

	/* SAVING STATE INFORMATION BELOW */

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		// Save UI state changes to the savedInstanceState.
		// This bundle will be passed to onCreate if the process is
		// killed and restarted.

		String from = edittext.getText().toString();
		String to = edittext2.getText().toString();
		String cc = edittext3.getText().toString();
		String bcc = edittext5.getText().toString();
		String subject = edittext6.getText().toString();

		savedInstanceState.putString("from", from);
		savedInstanceState.putString("to", to);
		savedInstanceState.putString("cc", cc);
		savedInstanceState.putString("bcc", bcc);
		savedInstanceState.putString("subject", subject);
		// etc.
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		String from = savedInstanceState.getString("from");
		edittext.setText(from);
		String to = savedInstanceState.getString("to");
		edittext2.setText(to);
		String cc = savedInstanceState.getString("cc");
		edittext3.setText(cc);
		String bcc = savedInstanceState.getString("bcc");
		edittext5.setText(bcc);
		String subject = savedInstanceState.getString("subject");
		edittext6.setText(subject);

	}

	/* ACTION BAR SHERLOCK MENU BELOW */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.options, (com.actionbarsherlock.view.Menu) menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			return (true);
		case R.id.about:
			openAbout();
			return (true);
		case R.id.feedback:
			openFeedback();
			return (true);
		case R.id.cancel:
			clearText();
			return (true);
		case R.id.send_email:
			sendMail();
			return (true);
		}
		return (super.onOptionsItemSelected(item));
	}

	/* Method to open feedback page from options menu */
	private void openFeedback() {
		Intent intent = new Intent();
		intent.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.FeedbackForm");
		startActivity(intent);
	}

	/* Method to open about page from options menu */
	private void openAbout() {
		Intent intent = new Intent();
		intent.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.About");
		startActivity(intent);
	}

	/* Method to clear text from ActionBar/options menu */
	private void clearText() {
		ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
		clearForm(group);
	}

	/*
	 * Method to send (or in this assignment preview) the email from
	 * actionbar/options menu
	 */
	private void sendMail() {
		Intent sentEmail = new Intent();
		sentEmail.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.ReadEmail");
		/*
		 * reads all the editText information and adds it to the intent - Find a
		 * way to do it with less code
		 */
		String from = edittext.getText().toString();
		sentEmail.putExtra("editText1", from);
		String to = edittext2.getText().toString();
		sentEmail.putExtra("editText2", to);
		String cc = edittext3.getText().toString();
		sentEmail.putExtra("editText3", cc);
		String bcc = edittext5.getText().toString();
		sentEmail.putExtra("editText5", bcc);
		String subject = edittext6.getText().toString();
		sentEmail.putExtra("editText6", subject);

		startActivity(sentEmail);
	}

	private void clearForm(ViewGroup group) {
		for (int i = 0, count = group.getChildCount(); i < count; ++i) {
			View view = group.getChildAt(i);
			if (view instanceof EditText) {
				((EditText) view).setText("");
				((EditText) view).setBackgroundColor(Color.WHITE);
			}

			if (view instanceof ViewGroup
					&& (((ViewGroup) view).getChildCount() > 0))
				clearForm((ViewGroup) view);
		}
	}

	/*
	 * THE BELOW CODE ALLOWS US TO FORMAT THE TEXT AFTER THE USER HAS FINISHED
	 * ENTERING THIS IN THIS ASSIGNMENT THE EMAILS ARE UNDERLINED - HIGHLIGHTING
	 * ATTEMPTED BUT NEEDS PADDING TO LOOK GOOD
	 */

	class Foo implements OnFocusChangeListener {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {

			v = (EditText) v;
			if (hasFocus) {
				v.setBackgroundColor(Color.WHITE);
				((EditText) v).setTextColor(Color.BLACK);
			} else {

				/*
				 * Below highlights the email addresses with underlines after
				 * the user has entered them and moved on
				 */
				SpannableStringBuilder emailFormat = new SpannableStringBuilder();
				String emailFormatted = ((EditText) v).getText().toString();
				SpannableString formattedString = new SpannableString(
						emailFormatted);
				/*
				 * could use the below to highlight text - but does not look
				 * great (needs padding)
				 * 
				 * formattedString.setSpan(new
				 * BackgroundColorSpan(Color.rgb(238,233,233)), 0,
				 * emailFormatted.length(), 0);
				 */
				formattedString.setSpan(new UnderlineSpan(), 0,
						emailFormatted.length(), 0);

				emailFormat.append(formattedString);

				((EditText) v).setText(emailFormat, BufferType.SPANNABLE);

			}

		}

	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
