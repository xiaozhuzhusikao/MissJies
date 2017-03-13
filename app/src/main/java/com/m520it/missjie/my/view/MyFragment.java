package com.m520it.missjie.my.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;

/**
 * @author Herbert
 * @time 2017/2/21 0021 下午 19:49
 * @des ${TODO}
 */

public class MyFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {

    }
}
