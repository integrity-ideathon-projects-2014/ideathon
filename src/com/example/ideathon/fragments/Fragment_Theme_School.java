package com.example.ideathon.fragments;

import com.example.ideathon.GameActivity;
import com.example.ideathon.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment_Theme_School extends Fragment{
	
	ImageView btnback;
	Button playtheme;

	ViewPager pager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_class, container, false);

		playtheme = (Button) view.findViewById(R.id.gameplay);
		pager = (ViewPager) getActivity().findViewById(R.id.pager);
		btnback = (ImageView) view.findViewById(R.id.btnback);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		btnback.setOnClickListener(new OnClickListener() {

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
				intent.putExtra("question", 1);
				startActivity(intent);
			}
		});

	}

}
