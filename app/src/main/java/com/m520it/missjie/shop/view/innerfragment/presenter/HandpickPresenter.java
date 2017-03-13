package com.m520it.missjie.shop.view.innerfragment.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.m520it.missjie.shop.bean.MenBean;
import com.m520it.missjie.shop.bean.ReturnResultBean;
import com.m520it.missjie.shop.view.innerfragment.View.IHandpickFragment;
import com.m520it.missjie.shop.view.innerfragment.model.HandpicModel;
import com.m520it.missjie.shop.view.innerfragment.model.IHandpicM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * @author gezi
 * @time 2017/3/7  0:03
 * @desc 精选界面的p
 */
public class HandpickPresenter implements IHandpickP,IHandpicM.IHandpicListener{
    private final HandpicModel mModel;
    private IHandpickFragment mView;

    public HandpickPresenter(IHandpickFragment view) {
        //找到公司内部的运营部经理
        mModel = new HandpicModel(this);
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
        //通知View展示界面
        ReturnResultBean resultBean = JSON.parseObject((String) obj,ReturnResultBean.class);
       // Log.e("Thread",Thread.currentThread().getName());
        try {
            if (resultBean.isSuccess()) {
                JSONObject jsonObject = new JSONObject(resultBean.getResult());
                String rowsJson = jsonObject.getString("rows");
                List<MenBean.RowsBean> rowsBeen = JSON.parseArray(rowsJson, MenBean.RowsBean.class);
                mView.showData(rowsBeen);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
