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
			requestWindowFeature(Window.FEATURE_NO_TITLE); // ȡ������
		}
		setContentView(setMyContentView());
		findViews();
		init();
		setListeners();
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

}
