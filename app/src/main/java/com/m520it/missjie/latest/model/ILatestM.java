package com.m520it.missjie.latest.model;

import android.content.Context;

/**
 * @author Herbert
 * @time 2017/3/7 0007 上午 11:23
 * @des ${TODO}
 */

public interface ILatestM {

    void doGetRequest(int requestID, String url, Context context);

    //回调监听
    interface ILatestListener{

        void onDataReseted(String resultStr);

    }
}
