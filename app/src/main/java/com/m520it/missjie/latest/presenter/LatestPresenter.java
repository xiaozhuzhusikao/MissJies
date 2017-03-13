package com.m520it.missjie.latest.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.m520it.missjie.latest.bean.LatestBean;
import com.m520it.missjie.latest.model.ILatestM;
import com.m520it.missjie.latest.model.LatestModel;
import com.m520it.missjie.latest.view.ILatestV;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/7 0007 上午 11:19
 * @des ${TODO}
 */

public class LatestPresenter implements ILatestP, ILatestM.ILatestListener {
    private ILatestV mView;
    private LatestModel mModel;

    public LatestPresenter(ILatestV view) {
        mModel = new LatestModel(this);
        this.mView = view;

    }

    @Override
    public void doGetRequest(int requestID, String url, Context context) {
        //通知View展示一个正在加载中的页面
        //mView.showLoading();
        //通知Model做一个网络请求
        mModel.doGetRequest(requestID, url, context);
    }

    @Override
    public void onDataReseted(String resultStr) {
        //Log.e("xxx", obj.toString());
        LatestBean persons = JSON.parseObject(resultStr, LatestBean.class);
        List<LatestBean.ItemBean> data = persons.getData();
        mView.showUI(data);

    }
}
