package com.m520it.missjie.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;

import com.m520it.missjie.activity.MyApplication;

/**
 * @author Herbert
 * @time 2017/2/19 0019 下午 19:40
 * @des ${TODO}
 */

public class ActivityUtil {
    public static void startActivity(Context c, Class<? extends Activity> clazz, boolean ifFinish) {
        Intent intent = new Intent(c, clazz);
        c.startActivity(intent);
        if (ifFinish) {
            ((Activity) c).finish();
        }
    }

    public static void showTip(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 得到上下文
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * 得到res文件对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }


    /**
     * 获取String.xml文件中的字符数组
     */
    public static String[] getStringArr(int resId) {
        return getResources().getStringArray(resId);
    }
}
