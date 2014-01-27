package com.example.ideathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.ideathon.fragments.Fragment_Theme_Community;
import com.example.ideathon.fragments.Fragment_Theme_Office;
import com.example.ideathon.fragments.Fragment_Theme_School;
import com.example.preferences.ProjectPreferences;

public class PlayTheme extends FragmentActivity{

	ViewPager pager;
	FragmentPagerAdapter adapter;
	
	TextView username;
	ProjectPreferences pref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playtheme);
		
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new CustomAdapter(getSupportFragmentManager());
		
		pref = new ProjectPreferences(getApplicationContext());
		
		String name = "User";
		
		username = (TextView)findViewById(R.id.username);
		
		name = pref.getName();
		username.setText("Welcome, "+ name);
		
		pager.setAdapter(adapter);
		
	}
	
	class CustomAdapter extends FragmentPagerAdapter {

//		private final String[] TITLES = { "Routes", "Order Summary" };

		public CustomAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new Fragment_Theme_Community();
				break;
			case 1:
				fragment = new Fragment_Theme_Office();
				break;
			case 2:
				fragment = new Fragment_Theme_School();
			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		/*@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}*/
	}
	

	
	
}
