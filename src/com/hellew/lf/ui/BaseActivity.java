package com.hellew.lf.ui;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.hellew.lf.UIInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public abstract class BaseActivity extends Activity implements UIInfo {
	private boolean mAllowFullScreen = true;
	// 对所有的activity进行管理
	private static List<Activity> mActivities = new LinkedList<Activity>();
	private static Activity mCurrentActivity;

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
		synchronized (mActivities) {
			mActivities.add(this); // 添加activity
		}
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

	@Override
	protected void onDestroy() {
		super.onDestroy();

		synchronized (mActivities) {
			mActivities.remove(this);// 移除activity
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		mCurrentActivity = this; // 获取当前的activity
	}

	@Override
	protected void onPause() {
		super.onPause();
		mCurrentActivity = null; // 清空当前activity
	}

	/**
	 * 释放所有activity
	 */
	public static void exitApp() {

		ListIterator<Activity> iterator = mActivities.listIterator();
		while (iterator.hasNext()) {
			Activity next = iterator.next();
			next.finish();
		}
	}

}
