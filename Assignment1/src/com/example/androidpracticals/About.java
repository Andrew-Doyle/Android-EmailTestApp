package com.example.androidpracticals;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class About extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* stops keybord from automatically popping up */
		// getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(R.layout.about);

		// TextView textviewcontent2;

		// textviewcontent2 = (TextView) findViewById(R.id.textView2);
		// /* set Text View to HTML FORMAT (FOR NUMBERED LIST ETC..): */
		// Resources res = getResources();
		// String from = String.format(res.getString(R.string.appdescription));
		// CharSequence styledText = Html.fromHtml(from);
		// textviewcontent2.setText(styledText);
		// String from = textviewcontent1.getText().toString();
		// textviewcontent1.setText(Html.fromHtml(from));

		// final EditText name = (EditText) findViewById(R.id.editText1);
		// final EditText mailaddress = (EditText) findViewById(R.id.editText2);
		// final EditText comment = (EditText) findViewById(R.id.editText3);
		//
		/*
		 * textViewA = (TextView) findViewById(R.id.textView1); textViewB=
		 * (TextView) findViewById(R.id.textView2); suggestion = (RadioGroup)
		 * findViewById(R.id.radioButton1); reportProblem = (RadioGroup)
		 * findViewById(R.id.radioButton2);
		 */
		// clearForm = (Button) findViewById(R.id.button3);
		// sendForm = (Button) findViewById(R.id.button4);
		// clearForm.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// ViewGroup group = (ViewGroup) findViewById(R.id.rootLayout);
		// clearForm(group);
		//
		// }
		// });

		// sendForm.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// }
		// });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.options_about, menu);

		return (super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
		
			return (true);
		case R.id.feedback:
			openFeedback();
			return (true);
		case R.id.go_back:
			onBackPressed();
			return (true);
		case R.id.new_email:
			newEmail();
			return (true);

		}
		return (super.onOptionsItemSelected(item));
	}

	/* Method to open feedback page from actionbar/options menu */
	private void openFeedback() {
		Intent intent = new Intent();
		intent.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.FeedbackForm");
		startActivity(intent);
	}

	/* Method to go to composition email activity from actionbar/options menu */
	private void newEmail() {
		Intent sendEmail = new Intent();
		sendEmail.setClassName("com.example.androidpracticals",
				"com.example.androidpracticals.MainActivity");
		startActivity(sendEmail);
	}

}
