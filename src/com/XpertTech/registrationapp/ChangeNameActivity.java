package com.XpertTech.registrationapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

public class ChangeNameActivity extends Activity {
	public final static String NAME = "namePrefs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_name);
		// Show the Up button in the action bar.
		setupActionBar();

		TextView viewOldDoneName= (TextView)findViewById(R.id.viewDoneName);
		SharedPreferences name= getSharedPreferences(NAME, 0);
		String OldNameUser=name.getString("userName", "Nothing Found ");
		viewOldDoneName.setText(OldNameUser);
		Button btndone= (Button)findViewById(R.id.btnDoneName);
		final EditText newNameDone= (EditText)findViewById(R.id.editDoneName);

		btndone.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0)
			{
				SharedPreferences namePrefs= getSharedPreferences(NAME, 0);
				Editor editor= namePrefs.edit();
				editor.commit();
				Intent i= new Intent(getApplicationContext(), MainActivity.class);
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
		getMenuInflater().inflate(R.menu.change_name, menu);
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
