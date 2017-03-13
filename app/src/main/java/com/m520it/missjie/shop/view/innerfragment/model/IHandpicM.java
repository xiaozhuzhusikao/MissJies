package com.m520it.missjie.shop.view.innerfragment.model;

import android.content.Context;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:55
 * @des ${TODO}
 */

public interface IHandpicM {
    void doGetRequest(int requestID, String url, Context context);

    //回调监听,当网络请求完毕后进行数据的返回
     interface IHandpicListener{

        void onDataReseted(Object obj);

    }
}
