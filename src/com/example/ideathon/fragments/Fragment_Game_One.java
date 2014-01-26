package com.example.ideathon.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ideathon.GameActivity;
import com.example.ideathon.R;

public class Fragment_Game_One extends Fragment{
	
	ImageView btnfwd;
	Button playtheme;
	
	ViewPager pager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_community, container, false);
		btnfwd = (ImageView)view.findViewById(R.id.btnfwd);
		playtheme = (Button)view.findViewById(R.id.gameplay);
		pager = (ViewPager)getActivity().findViewById(R.id.pager);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		btnfwd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pager.setCurrentItem(1, true);
			}
		});
		
		playtheme.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), GameActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
	
	
	

}
