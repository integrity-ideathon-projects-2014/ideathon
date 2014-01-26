package com.example.ideathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ideathon.R;

public class Fragment_Game_Two extends Fragment {

	TextView textTwo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_game_two, container,
				false);
		textTwo = (TextView) view.findViewById(R.id.textTwo);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		int i = getActivity().getIntent().getIntExtra("question", 1);

		if (i == 1) {
			textTwo.setText(getActivity().getResources()
					.getString(R.string.a_b));
		} else if (i == 2) {
			textTwo.setText(getActivity().getResources()
					.getString(R.string.b_b));
		} else {
			textTwo.setText(getActivity().getResources()
					.getString(R.string.c_b));
		}
	}

}
