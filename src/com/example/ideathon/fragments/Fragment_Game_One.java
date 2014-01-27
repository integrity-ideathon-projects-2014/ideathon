package com.example.ideathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ideathon.R;

public class Fragment_Game_One extends Fragment{
	
	TextView textOne;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_game_one, container, false);
		
		textOne = (TextView)view.findViewById(R.id.textOne);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		int i = getActivity().getIntent().getIntExtra("question", 1);
		
		if(i == 1) {
			textOne.setText(getActivity().getResources().getString(R.string.a_a));
		}
		else if(i == 2) {
			textOne.setText(getActivity().getResources().getString(R.string.b_a));
		}
		else {
			textOne.setText(getActivity().getResources().getString(R.string.c_a));
		}
	}
	
	
	
	
}
