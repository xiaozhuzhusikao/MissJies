package com.m520it.missjie.home.view.innerfragment.recommend.presenter;

import android.content.Context;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:54
 * @des ${TODO}
 */

public interface IRecommendP {
    void doGetRequest(int requestID, String url, Context context);//发送网络请求
}
