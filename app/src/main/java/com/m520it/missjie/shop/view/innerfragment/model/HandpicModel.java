package com.m520it.missjie.shop.view.innerfragment.model;

import android.content.Context;

import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:55
 * @des 精选界面的model，做真正的网络请求
 */

public class HandpicModel implements IHandpicM {

    private IHandpicListener mListener;

    public HandpicModel(IHandpicListener listener) {
        mListener = listener;
    }

    /**
     * @param requestID  区别自身的id
     * @param url  网络请求地址
     */
    @Override
    public void doGetRequest(final int requestID, String url, Context context) {
        HttpHelper.getInstance(context).requestGETStringResult(url, new HttpStringCallBack() {
            @Override
            public void onSuccessResponse(String result) {
                mListener.onDataReseted(result);
            }

            @Override
            public void onFailResponse(Exception e) {

            }
        });
    }
}
