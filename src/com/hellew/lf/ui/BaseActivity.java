package com.hellew.lf.ui;

import com.hellew.lf.UIInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public abstract class BaseActivity extends Activity implements UIInfo {
	private boolean mAllowFullScreen = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mAllowFullScreen) {
			requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
		}
		setContentView(setMyContentView());
		findViews();
		init();
		setListeners();
	}

	protected abstract int setMyContentView();

	protected abstract void findViews();// 找到组件

	protected abstract void init();// 注册信息

	protected abstract void setListeners();// 设置监听

	/**
	 * 是否取消标题
	 * 
	 * @param allowFullScreen
	 */
	public void setAllowFullScreen(boolean allowFullScreen) {
		this.mAllowFullScreen = allowFullScreen;
	}

}
