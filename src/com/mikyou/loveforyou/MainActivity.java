package com.mikyou.loveforyou;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.mikyou.myview.LoveLayout;

public class MainActivity extends Activity {
	private LoveLayout mLoveLayout;
	private boolean flag=true;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.what==0x123) {
				mLoveLayout.addLove();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mLoveLayout=(LoveLayout)findViewById(R.id.id_love_layout);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(flag){
						Thread.sleep(100);
						handler.sendEmptyMessage(0x123);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("qwer","ondestory");
		flag=false;
		super.onDestroy();
	}

}
