package com.example.ideathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.ideathon.fragments.Fragment_Game_One;
import com.example.ideathon.fragments.Fragment_Game_Two;

public class GameActivity extends FragmentActivity {

	ViewPager gamepager;
	FragmentPagerAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamepage);
		
		gamepager = (ViewPager)findViewById(R.id.gamepager);
		adapter = new CustomAdapter(getSupportFragmentManager());
		
		gamepager.setAdapter(adapter);
		
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

		/*@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}*/
	}

}
