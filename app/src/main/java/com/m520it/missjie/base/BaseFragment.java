package com.m520it.missjie.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public abstract class BaseFragment extends Fragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        initPresenter();
        initListener();
    }

    //初始化界面
    protected abstract void initUI();

    //初始化presenter
    protected abstract void initPresenter();

    //初始化监听
    protected abstract void initListener();


}
