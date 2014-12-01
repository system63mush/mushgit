package com.mushsoft.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.mushsoft.mush.R;
import com.mushsoft.utils.Utils;
import com.mushsoft.view.ContentView;
import com.mushsoft.view.DrawLineView.GestureCallBack;

public class OpenLockActivity extends Activity {
	private final String TAG = "MainActivity";
	private FrameLayout body_layout;
	private ContentView mContentView;
	
	private Context mContext = OpenLockActivity.this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	
	private void initView(){
		body_layout = (FrameLayout) findViewById(R.id.body_layout);
	}
	
	private void initData(){
		// 初始化一个显示各个点的viewGroup
		mContentView = new ContentView(this,new GestureCallBack() {
			@Override
			public void checkedSuccess() {
				Utils.toast(mContext, "校验成功");
				startActivity(new Intent(mContext,LoginActivity.class));
				finish();
			}
			
			@Override
			public void checkedFail() {
				Utils.toast(mContext, "校验失败");
			}

			@Override
			public void setSuccess() {
				Utils.toast(mContext, "设置成功");
			}
		});
		//设置手势解锁显示到哪个布局里面
		mContentView.setParentView(body_layout);
	}

}
