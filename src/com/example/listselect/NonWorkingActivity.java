package com.example.listselect;

import android.os.Bundle;
import android.view.View;

public class NonWorkingActivity extends MainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_button.setText("Go back to working sample");
	}
	
	@Override
	protected int getRowLayout()
	{
		return R.layout.row;
	}
	
	@Override
	public void onClick(View v) 
	{
		finish();
	}
}
