package com.m520it.missjie.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.m520it.missjie.activity.MainActivity;
import com.m520it.missjie.R;
import com.m520it.missjie.utils.ActivityUtil;

import me.wangyuwei.particleview.ParticleView;

/**
 * @author Herbert
 * @time 2017/2/19 0019 下午 19:10
 * @des ${TODO}
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ImageView splashIv = (ImageView) findViewById(R.id.splash_iv);
        ParticleView particleView = (ParticleView) findViewById(R.id.particleView);
        particleView.startAnim();
        splashIv.setBackgroundResource(R.drawable.splash);
        ObjectAnimator animtor = ObjectAnimator.ofFloat(splashIv, "alpha", 0.3f, 1.0f);
        animtor.setDuration(6000);
        animtor.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //启动一个登陆的界面
                ActivityUtil.startActivity(SplashActivity.this, MainActivity.class,
                        true);
            }

        });
        animtor.start();
    }
}
