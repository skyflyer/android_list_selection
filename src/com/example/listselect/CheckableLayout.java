package com.example.listselect;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CheckableLayout extends LinearLayout {

	private boolean _isChecked;

	public CheckableLayout(Context context) {
		super(context);
	}

	public CheckableLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CheckableLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setChecked(boolean isChecked) {
		if (_isChecked != isChecked) {
			_isChecked = isChecked;
			refreshDrawableState();
		}
	}

	private static final int[] STATE_CHECKED = new int[] { android.R.attr.state_checked };
	@Override
	protected int[] onCreateDrawableState(int extraSpace) {
		int[] baseState = super.onCreateDrawableState(extraSpace + 1);
		if (_isChecked) {
			mergeDrawableStates(baseState, STATE_CHECKED);
		}
		return baseState;
	}
}
