package com.XpertTech.registrationapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

public class ThirdActivity extends Activity {
	public final static String PASS = "passwordPrefs";
	boolean _equalPassword=false;
	boolean _isBackPressed=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		// Show the Up button in the action bar
		setupActionBar();

		TextView viewOldPasswords= (TextView)findViewById(R.id.viewOldPassword);
		SharedPreferences password= getSharedPreferences(PASS, 0);
		String oldPasswordUser=password.getString("userPassword", " ");
		viewOldPasswords.setText(oldPasswordUser);
		final EditText newPass= (EditText)findViewById(R.id.editNewPwd);
		final EditText confirmPass= (EditText)findViewById(R.id.editConfirmPwd);
		Button btnback= (Button)findViewById(R.id.btnBack);
		btnback.setOnClickListener(new OnClickListener()
		{

			//@Override
			public void onClick(View v)
			{
				onBackPressed(); 

			};
			//	@Override
			public void onBackPressed() 
			{
				String password2= newPass.getText().toString();
				String password1 =  confirmPass.getText().toString();
				if(password1.equals(password2))
				{
					_equalPassword=true;

					//	Super.OnBackPressed();
					_isBackPressed=true;
					finish();
				}

				else _equalPassword=false;
			}
		});
	};

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
