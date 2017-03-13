package com.m520it.missjie.latest.model;

import android.content.Context;

import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

/**
 * @author Herbert
 * @time 2017/3/7 0007 上午 11:20
 * @des ${TODO}
 */

public class LatestModel implements ILatestM {
    private ILatestListener mListener;

    public LatestModel(ILatestListener listener) {
        mListener = listener;
    }

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
