package com.m520it.missjie.home.presenter;

import android.app.Activity;
import android.content.Context;

/**
 * @author Herbert
 * @time 2017/2/22 0022 下午 20:43
 * @des ${TODO}
 */

public interface IHomePresenter {
    void startActivity(Context context, Class<? extends Activity> clz, boolean ifFinish);
}
