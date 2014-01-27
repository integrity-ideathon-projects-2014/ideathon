package com.example.ideathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	Button start;
	private MainFragment mainFragment;
	private Layout playlayout, logincontainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.signUp);
		start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentsignUp = new Intent(MainActivity.this,
						signUp.class);
				System.out.println("ONCLICK---------");
				startActivity(intentsignUp);
			}
		});
		if (savedInstanceState == null) {
			// Add the fragment on initial activity setup
			mainFragment = new MainFragment();
			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, mainFragment).commit();
			System.out.println("savedInstanceState is null");
		} else {
			// Or set the fragment from restored state info
			mainFragment = (MainFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);
			System.out.println("savedInstanceState isn't null");
		}

	}
}
