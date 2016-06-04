package com.hellew.lf.ui;

import com.hellew.lf.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SlidingDrawer;

/**
 * 
 * @author hellew 这是选择页面 进行出门，在家，常规查询的跳转
 */
public class ChooseUI extends BaseActivity {

	@Override
	protected int setMyContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_choose;
	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Intent intent = new Intent(this, MainLeft.class);
		// startActivity(intent);
		Intent intent = new Intent(this, MainRight.class);
		startActivity(intent);

	}

	@Override
	protected void setListeners() {
		// TODO Auto-generated method stub

	}
}
