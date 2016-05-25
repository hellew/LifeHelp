package com.hellew.lf.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;

import com.hellew.lf.R;

/**
 * 
 * @author hellew 进入应用的欢迎动画
 */
public class WelcomeUI extends BaseActivity {

	private TextView _welcome_tv_title;
	private TextView _welcome_tv_subtitle;

	@Override
	protected void findViews() {
		_welcome_tv_title = (TextView) findViewById(R.id.welcome_tv_title);
		_welcome_tv_subtitle = (TextView) findViewById(R.id.welcome_tv_subtitle);
	}

	@Override
	protected void init() {
		AnimatorSet animSet = new AnimatorSet();
		_welcome_tv_title.setText("生活小助手");
		_welcome_tv_title.setTextSize(20);
		_welcome_tv_subtitle.setText("小猪会每天伴您左右");
		_welcome_tv_subtitle.setVisibility(View.GONE);
		ObjectAnimator moveIn = ObjectAnimator.ofFloat(_welcome_tv_title,
				"translationY", -500f, 0f);
		ObjectAnimator animatorY = ObjectAnimator.ofFloat(_welcome_tv_title,
				"scaleY", 1f, 3f, 1f);
		ObjectAnimator animatorX = ObjectAnimator.ofFloat(_welcome_tv_title,
				"scaleX", 1f, 3f, 1f);
		animSet.play(animatorY).with(animatorX).with(moveIn);
		animSet.setDuration(2000);
		animSet.start();
		animSet.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				_welcome_tv_subtitle.setVisibility(View.VISIBLE);
				ObjectAnimator subAnim = ObjectAnimator.ofFloat(

				_welcome_tv_subtitle, "alpha", 0f, 1f);
				subAnim.setDuration(1000);
				subAnim.start();
			}

			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	protected void setListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected int setMyContentView() {
		return R.layout.activity_welcome;
	}

}
