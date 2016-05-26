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
	// �����е�activity���й���
	private static List<Activity> mActivities = new LinkedList<Activity>();
	private static Activity mCurrentActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mAllowFullScreen) {
			requestWindowFeature(Window.FEATURE_NO_TITLE); // ȡ������
		}
		setContentView(setMyContentView());
		findViews();
		init();
		setListeners();
		synchronized (mActivities) {
			mActivities.add(this); // ���activity
		}
	}

	protected abstract int setMyContentView();

	protected abstract void findViews();// �ҵ����

	protected abstract void init();// ע����Ϣ

	protected abstract void setListeners();// ���ü���

	/**
	 * �Ƿ�ȡ������
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
			mActivities.remove(this);// �Ƴ�activity
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		mCurrentActivity = this; // ��ȡ��ǰ��activity
	}

	@Override
	protected void onPause() {
		super.onPause();
		mCurrentActivity = null; // ��յ�ǰactivity
	}

	/**
	 * �ͷ�����activity
	 */
	public static void exitApp() {

		ListIterator<Activity> iterator = mActivities.listIterator();
		while (iterator.hasNext()) {
			Activity next = iterator.next();
			next.finish();
		}
	}

}
