package com.example.ideathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.ideathon.customdialog.CustomDialog;
import com.example.ideathon.fragments.Fragment_Game_One;
import com.example.ideathon.fragments.Fragment_Game_Two;
import com.example.preferences.ProjectPreferences;

public class GameActivity extends FragmentActivity {

	ViewPager gamepager;
	FragmentPagerAdapter adapter;

	Button optiona, optionb, optionc, optiond;
	String[] optionset;

	int mode;

	int scorea, scoreb, scorec, scored;

	ProjectPreferences pref;
	CustomDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamepage);

		gamepager = (ViewPager) findViewById(R.id.gamepager);
		adapter = new CustomAdapter(getSupportFragmentManager());

		pref = new ProjectPreferences(getApplicationContext());

		mode = getIntent().getIntExtra("question", 1);
		dialog = new CustomDialog(getApplicationContext(), GameActivity.this);

		if (mode == 1) {
			optionset = getResources().getStringArray(R.array.a_options);
			scorea = 1;
			scoreb = 1;
			scorec = 2;
			scored = 5;
		}
		if (mode == 2) {
			optionset = getResources().getStringArray(R.array.b_options);
			scorea = 5;
			scoreb = 1;
			scorec = 1;
			scored = 1;
		}
		if (mode == 3) {
			optionset = getResources().getStringArray(R.array.c_options);
			scorea = 1;
			scoreb = 5;
			scorec = 1;
			scored = 1;
		}

		optiona = (Button) findViewById(R.id.optionOne);
		optionb = (Button) findViewById(R.id.optionTwo);
		optionc = (Button) findViewById(R.id.optionThree);
		optiond = (Button) findViewById(R.id.optionFour);

		optiona.setText(optionset[0]);
		optionb.setText(optionset[1]);
		optionc.setText(optionset[2]);
		optiond.setText(optionset[3]);

		optiona.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (mode == 1 || mode == 2) {
					Toast.makeText(getApplicationContext(), "+" + scorea,
							Toast.LENGTH_SHORT).show();
					finish();
					Intent intent = new Intent(GameActivity.this,
							GameActivity.class);
					if (mode == 1) {
						intent.putExtra("question", 2);
					}
					if (mode == 2) {
						intent.putExtra("question", 3);
					}
					pref.setLevel(pref.getLevel() + scorea);
					startActivity(intent);
				} else {
					dialog.show();
				}
			}
		});

		optionb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mode == 1 || mode == 2) {
					Toast.makeText(getApplicationContext(), "+" + scoreb,
							Toast.LENGTH_SHORT).show();
					finish();
					Intent intent = new Intent(GameActivity.this,
							GameActivity.class);
					if (mode == 1) {
						intent.putExtra("question", 2);
					}
					if (mode == 2) {
						intent.putExtra("question", 3);
					}
					pref.setLevel(pref.getLevel() + scoreb);
					startActivity(intent);
				} else {
					dialog.show();
				}
			}
		});

		optionc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mode == 1 || mode == 2) {
					Toast.makeText(getApplicationContext(), "+" + scorec,
							Toast.LENGTH_SHORT).show();
					finish();
					Intent intent = new Intent(GameActivity.this,
							GameActivity.class);
					if (mode == 1) {
						intent.putExtra("question", 2);
					}
					if (mode == 2) {
						intent.putExtra("question", 3);
					}
					pref.setLevel(pref.getLevel() + scorec);
					startActivity(intent);
				} else {
					dialog.show();
				}
			}
		});

		optiond.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mode == 1 || mode == 2) {
					Toast.makeText(getApplicationContext(), "+" + scored,
							Toast.LENGTH_SHORT).show();
					finish();
					Intent intent = new Intent(GameActivity.this,
							GameActivity.class);
					if (mode == 1) {
						intent.putExtra("question", 2);
					}
					if (mode == 2) {
						intent.putExtra("question", 3);
					}
					pref.setLevel(pref.getLevel() + scored);
					startActivity(intent);
				} else {
					dialog.show();
				}
			}
		});

		gamepager.setAdapter(adapter);

	}

	class CustomAdapter extends FragmentPagerAdapter {

		// private final String[] TITLES = { "Routes", "Order Summary" };

		public CustomAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new Fragment_Game_One();
				break;
			case 1:
				fragment = new Fragment_Game_Two();
				break;
			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		/*
		 * @Override public CharSequence getPageTitle(int position) { return
		 * TITLES[position]; }
		 */
	}

}
