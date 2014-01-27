package com.example.ideathon.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.ideathon.MainFragment;
import com.example.ideathon.PlayTheme;
import com.example.ideathon.R;
import com.example.preferences.ProjectPreferences;


public class CustomDialog extends Dialog implements
		android.view.View.OnClickListener {

	ProjectPreferences pref;
	
	TextView name, country, score, playagain, share;
	Button add;
	String text_title;
	Activity a;
	

	public CustomDialog(Context context, Activity a ) {
		super(a);
		this.a = a;
		pref = new ProjectPreferences(context);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.finish_dialog);

		name = (TextView) findViewById(R.id.playername);
		country = (TextView) findViewById(R.id.playercountry);
		score = (TextView) findViewById(R.id.scoreplayer);
		
		playagain = (TextView)findViewById(R.id.playagain);
		share = (TextView)findViewById(R.id.share);
		
		playagain.setOnClickListener(this);
		share.setOnClickListener(this);
		
//		add = (Button) findViewById(R.id.addtocart);
		name.setText(pref.getName());
//		country.setText(getCountry(pref.getCountry().toString()));
		score.setText(String.valueOf(pref.getLevel()));

	}

	private String getCountry(String location) {
		// TODO Auto-generated method stub
		int len = location.length()-2;
		int start = location.indexOf("name")+6;
		return location.substring(start, len);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.playagain:
			a.finish();
			Intent intent = new Intent(a, PlayTheme.class);
			a.startActivity(intent);
			break;
		case R.id.share:
//			MainFragment.postupdate();
			a.finish();
			break;
		}
	}

}
