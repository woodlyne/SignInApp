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

public class WelcomePageActivity extends Activity {
	public final static String NAME = "namePrefs";
	public final static String PASS= "passwordPrefs";
	String _oldMessage;
	String _oldName;
	boolean _samePassword=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_page);
		// Show the Up button in the action bar.
		setupActionBar();

		TextView viewName= (TextView)findViewById(R.id.viewMyName);
		SharedPreferences name= getSharedPreferences(NAME, 0);
		final String userString=name.getString("userName", " ");
		SharedPreferences pass= getSharedPreferences(PASS, 0);
		final String oldString=pass.getString("userpassword", pass.getString("userPassword", " "));
		viewName.setText(userString);

		///java statement for third activity
		Button ChangePwdBtn= (Button)findViewById(R.id.btnChangePwd);
		Button ChangeNameBtn= (Button)findViewById(R.id.btnChangeName);

		ChangePwdBtn.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0)
			{
				String pwd=oldString;
				SharedPreferences passwordPrefs= getSharedPreferences(PASS, 0);
				Editor editor= passwordPrefs.edit();
				editor.putString("userPassword", pwd);
				editor.commit();
				Intent i= new Intent(getApplicationContext(), ThirdActivity.class);
				startActivity(i);
			};
		});


		ChangeNameBtn.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0)
			{
				_oldName= userString;
				SharedPreferences namePrefs= getSharedPreferences(NAME, 0);
				Editor editor= namePrefs.edit();
				editor.putString("userName", _oldName);
				editor.commit();
				Intent i= new Intent(getApplicationContext(), ChangeNameActivity.class);
				startActivity(i);
			};
		});
	}
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
		getMenuInflater().inflate(R.menu.welcome_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
