package com.hellew.lf.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hellew.lf.R;

/**
 * 
 * @author hellew 进入应用的欢迎动画
 */
public class WelcomeUI extends BaseActivity {

	private TextView _welcome_tv_title;
	private TextView _welcome_tv_subtitle;
	private ImageView _welcome_iv_pig;
	private AnimatorSet animSet;
	private ObjectAnimator subAnim;

	@Override
	protected void findViews() {
		_welcome_tv_title = (TextView) findViewById(R.id.welcome_tv_title);
		_welcome_tv_subtitle = (TextView) findViewById(R.id.welcome_tv_subtitle);
		_welcome_iv_pig = (ImageView) findViewById(R.id.welcome_iv_pig);
	}

	@Override
	protected void init() {
		animSet = new AnimatorSet();

		_welcome_tv_title.setText("生活小助手");
		_welcome_tv_title.setTextSize(20);

		_welcome_tv_subtitle.setText("小猪会每天伴您左右");
		_welcome_tv_subtitle.setVisibility(View.GONE);

		_welcome_iv_pig.setVisibility(View.GONE);

		ObjectAnimator moveIn = ObjectAnimator.ofFloat(_welcome_tv_title,
				"translationY", -500f, 0f);

		ObjectAnimator animatorY = ObjectAnimator.ofFloat(_welcome_tv_title,
				"scaleY", 1f, 3f, 1f);
		ObjectAnimator animatorX = ObjectAnimator.ofFloat(_welcome_tv_title,
				"scaleX", 1f, 3f, 1f);
		animSet.play(animatorY).with(animatorX).with(moveIn);
		animSet.setDuration(2000);
		animSet.start();

	}

	@Override
	protected void setListeners() {
		animSet.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				_welcome_iv_pig.setVisibility(View.VISIBLE);
				ObjectAnimator
						.ofFloat(_welcome_iv_pig, "rotationX", 0.0F, 360.0F)//
						.setDuration(500).start();
				_welcome_tv_subtitle.setVisibility(View.VISIBLE);

				subAnim = ObjectAnimator.ofFloat(_welcome_tv_subtitle, "alpha",
						0f, 1f);
				subAnim.setDuration(2000);
				subAnim.start();
				subAnim.addListener(new AnimatorListener() {

					@Override
					public void onAnimationStart(Animator animation) {

					}

					@Override
					public void onAnimationRepeat(Animator animation) {

					}

					@Override
					public void onAnimationEnd(Animator animation) {
						jump2next();

					}

					@Override
					public void onAnimationCancel(Animator animation) {

					}
				});

			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}
		});

	}

	@Override
	protected int setMyContentView() {
		return R.layout.activity_welcome;
	}

	private void jump2next() {
		Log.d("+++++++++++++++", "进来了");
		if (false) {// 进入引导页面

			Intent intent = new Intent(WelcomeUI.this, GuideUI.class);
			WelcomeUI.this.startActivity(intent);
			WelcomeUI.this.finish();
		} else {// 进入选择页面
			Intent intent = new Intent(WelcomeUI.this, ChooseUI.class);
			WelcomeUI.this.startActivity(intent);
		}
	}

}
