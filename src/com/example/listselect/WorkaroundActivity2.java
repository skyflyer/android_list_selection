package com.example.listselect;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class WorkaroundActivity2 extends ListActivity {

	protected Button _button;

	protected int getRowLayout() {
		return R.layout.row_no_bg;
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
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile", "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile","Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile" };

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}
		final CustomArrayAdapter adapter = new CustomArrayAdapter(this,	R.layout.row_checked, list);
		listview.setAdapter(adapter);
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
// Below could could optimize the need to call notifyDataSetChanged...
//				CheckableLayout checkableView = (CheckableLayout) view;
//				if (checkableView != null) {
//					// reset previous checked states!
//					checkableView.setChecked(true);
//				} else {
//					Log.e("", "View is not a checkable layout!");
//				}
				adapter.setChecked(position);
				Log.i("", "Item click on position: " + position);
				Log.i("", "Selected index:"
						+ getListView().getSelectedItemPosition()
						+ " item id: " + getListView().getSelectedItemId());
			}
		});
	}

	private class CustomArrayAdapter extends ArrayAdapter<String> {
		private int _layoutResourceId;
		private int _checkedPosition = -1;
		
		public void setChecked(int position)
		{
			_checkedPosition  = position;
			notifyDataSetChanged();
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null ) {
				LayoutInflater inflater = (LayoutInflater) getContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(_layoutResourceId, null, false);
			}

			TextView t = (TextView) convertView
					.findViewById(android.R.id.text1);
			t.setText(getItem(position));
			
			CheckableLayout view = (CheckableLayout) convertView;
			
			if (position == _checkedPosition) {
				view.setChecked(true);
			} else {
				view.setChecked(false);
			}

			return convertView;
		}

		public CustomArrayAdapter(Context context, int layoutResourceId, List<String> objects) {
			super(context, layoutResourceId, objects);
			_layoutResourceId = layoutResourceId;
		}
	}
}
