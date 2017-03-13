package com.m520it.missjie.home.view.innerfragment.recommend.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.model.IRecommendM;
import com.m520it.missjie.home.view.innerfragment.recommend.model.RecommendModel;
import com.m520it.missjie.home.view.innerfragment.recommend.view.IRecommendV;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/2/24 0024 下午 19:54
 * @des ${TODO}
 */

public class RecommendPresenter implements IRecommendP, IRecommendM.IRecommendListener {
    private IRecommendV mView;
    private RecommendModel mModel;

    public RecommendPresenter(IRecommendV view) {
        mModel = new RecommendModel(this);
        this.mView = view;

    }

    @Override
    public void doGetRequest(int requestID, String url, Context context) {
        //通知View展示一个正在加载中的页面
        //mView.showLoading();
        //通知Model做一个网络请求
        mModel.doGetRequest(requestID, url, context);
    }

    //页面数据请求完毕
    @Override
    public void onDataReseted(Object obj) {

        //Log.e("m520it", ((String) obj));
        String str = ((String) obj);
        List<RListBean> rListBeens = null;
        try {
            JSONObject objStr = new JSONObject(str);
            String listStr = objStr.getString("list");

            rListBeens = JSON.parseArray(listStr, RListBean.class);
            //Log.e("m520it", rListBeens.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.e("m520it",Thread.currentThread().getName());
        //通知View展示界面

        mView.showRv(rListBeens);

    }
}
