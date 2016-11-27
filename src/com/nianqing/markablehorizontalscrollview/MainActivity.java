package com.nianqing.markablehorizontalscrollview;

import com.nianqing.widget.MyHorizontalScrollView;
import com.nianqing.widget.MyHorizontalScrollView.ScrollType;
import com.nianqing.widget.MyHorizontalScrollView.ScrollViewListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private MyHorizontalScrollView myHorizontalScrollView;
	private TextView center;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myHorizontalScrollView = (MyHorizontalScrollView)findViewById(R.id.hsv);
		center = (TextView)findViewById(R.id.center); 
		
		myHorizontalScrollView.setOnScrollStateChangedListener(new ScrollViewListener() {
			
			@Override
			public void onScrollChanged(ScrollType scrolltype) { 
				switch (scrolltype) {
				case START:
					center.setText("START");
					break;
				case END:
					center.setText("END");
					break;
				case MIDDLE:
					center.setText("MIDDLE");
					break;
				default:
					break;
				}
			}
		});
	}

}
