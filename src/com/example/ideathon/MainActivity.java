package com.example.ideathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD

		start = (Button) findViewById(R.id.start);

=======
		start = (Button) findViewById(R.id.signUp);
>>>>>>> 17d8c1813919296e83f55967c6e2762b239b23d6
		start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
<<<<<<< HEAD
				Intent intent = new Intent(MainActivity.this, PlayTheme.class);
=======
				Intent intent = new Intent(MainActivity.this, signUp.class);
>>>>>>> 17d8c1813919296e83f55967c6e2762b239b23d6
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
