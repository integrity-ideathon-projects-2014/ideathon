package com.example.ideathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	Button signfb, signup, playmain;
	LinearLayout playcontainer, signcontainer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		signfb = (Button)findViewById(R.id.fbSign);
		signup = (Button)findViewById(R.id.signUp);
		
		signcontainer = (LinearLayout)findViewById(R.id.logincontainer);
		playcontainer = (LinearLayout)findViewById(R.id.playcontainer);
		
		playmain = (Button)findViewById(R.id.playmain);
		
		playmain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, PlayTheme.class);
				startActivity(intent);
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
