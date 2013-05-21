package com.example.listselect;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity implements OnClickListener {

	protected Button _button;

	protected int getRowLayout()
	{
		return R.layout.row_no_bg;
	}

	@Override
	public void onClick(View v) 
	{
		startActivity(new Intent(this, NonWorkingActivity.class));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ListView listview = (ListView) findViewById(android.R.id.list);
	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
	        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
	        "Android", "iPhone", "WindowsMobile" };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    final CustomArrayAdapter adapter = new CustomArrayAdapter(this, getRowLayout(), list);
	    listview.setAdapter(adapter);
	    listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	    
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
	    	  Log.i("", "Item click on position: " + position);
	    	  Log.i("", "Selected index:" + getListView().getSelectedItemPosition() + " item id: " + getListView().getSelectedItemId());
	      }
	    });

	    _button = (Button) findViewById(R.id.btnSwitch);
	    _button.setOnClickListener(this);

	    Button button2 = (Button) findViewById(R.id.btnSwitch2);
	    button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, WorkaroundActivity.class));
			}});
	    Button button3 = (Button) findViewById(R.id.btnSwitch3);
	    button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, WorkaroundActivity2.class));
			}});
	}

	private class CustomArrayAdapter extends ArrayAdapter<String> {
		private int _layoutResourceId;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(_layoutResourceId, null, false);
			}
			
			TextView t = (TextView) convertView.findViewById(android.R.id.text1);
			t.setText(getItem(position));

			return convertView;
		}


	    public CustomArrayAdapter(Context context, int layoutResourceId,   List<String> objects) {
	    	super(context, layoutResourceId, objects);
	    	_layoutResourceId = layoutResourceId;
	    }
	  }
}