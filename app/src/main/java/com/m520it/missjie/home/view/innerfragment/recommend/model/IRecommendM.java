package com.m520it.missjie.home.view.innerfragment.recommend.model;

import android.content.Context;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:55
 * @des ${TODO}
 */

public interface IRecommendM {
    void doGetRequest(int requestID, String url, Context context);

    //回调监听
     interface IRecommendListener{

        void onDataReseted(Object obj);

    }
}
