package com.m520it.missjie.activity;

import android.app.Application;
import android.content.Context;

/**
 * @author Herbert
 * @time 2017/2/26 0026 下午 17:04
 * @des ${TODO}
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        /*----------1.获取上下文----------*/
        mContext = getApplicationContext();
    }

    /**
     * 得到上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
