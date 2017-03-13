package com.m520it.missjie.home.view.innerfragment.recommend.model;

import android.content.Context;

import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:55
 * @des ${TODO}
 */

public class RecommendModel implements IRecommendM {

    private IRecommendListener mListener;

    public RecommendModel(IRecommendListener listener) {
        mListener = listener;
    }

    @Override
    public void doGetRequest(final int requestID, String url, Context context) {
       /* NetworkUtil.getInstance().requestGETStringResult(requestID, paramsMap, new HttpStringCallBack() {
            @Override
            public void onSuccessResponse(int responseID, String result) {
                switch (responseID) {
                    case IDiyMessage.RECOMMEND_ACTION:
                        mListener.onDataReseted(result);
                        break;
                }
            }
        });*/
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
