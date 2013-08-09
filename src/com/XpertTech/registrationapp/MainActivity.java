package com.XpertTech.registrationapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	boolean _RightPassword=false;
	EditText _editYourPwd;
	EditText _editYourName;
	public final static String NAME = "namePrefs";
	public final static String PASS = "passwordPrefs";
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_editYourName= (EditText)findViewById(R.id.editName1);
		Button submitBtn= (Button)findViewById(R.id.btnChangePwd);

		_editYourPwd= (EditText)findViewById(R.id.editPwd);
		final EditText editPwdConfirmation= (EditText)findViewById(R.id.confirmPwd);

		submitBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) 
			{
				String message= _editYourName.getText().toString();
				String message1= _editYourPwd.getText().toString();
				String message2= editPwdConfirmation.getText().toString();
				if(message1.equals(message2))
				{
					SharedPreferences namePrefs= getSharedPreferences(NAME, 0);
					Editor editor= namePrefs.edit();
					editor.putString("userName", message);
					editor.commit();

					SharedPreferences passwordPrefs= getSharedPreferences(PASS, 0);
					Editor ed= passwordPrefs.edit();
					ed.putString("userPassword", message1);
					ed.commit();
					Intent intentS= new Intent(getApplicationContext(),WelcomePageActivity.class);
					startActivity(intentS);

					_RightPassword=true;
				}
				else _RightPassword=false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
