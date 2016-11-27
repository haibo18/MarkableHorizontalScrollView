package com.nianqing.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class MyHorizontalScrollView extends HorizontalScrollView {

	public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyHorizontalScrollView(Context context) {
		super(context);
	}

	public interface ScrollViewListener {

		void onScrollChanged(ScrollType scrolltype);

	}

	public enum ScrollType {
		START, MIDDLE, END
	}

	private ScrollType scrolltype = ScrollType.START;
	
	private ScrollViewListener scrollViewListener;

	public void setOnScrollStateChangedListener(ScrollViewListener listener) {
		this.scrollViewListener = listener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		int maxScrollX = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
		if (getScrollX() == 0) {
			scrolltype = ScrollType.START;
		} else if (getScrollX() == maxScrollX) {
			scrolltype = ScrollType.END;
		} else {
			scrolltype = ScrollType.MIDDLE;
		}
		scrollViewListener.onScrollChanged(scrolltype);

	}
}