package com.m520it.missjie.shop.view.innerfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m520it.missjie.base.BaseFragment;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 18:01
 * @des ${TODO}
 */

public class ElectronicFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(container.getContext());
        tv.setText("数码");
        tv.setTextColor(Color.BLUE);
        tv.setTextSize(30);
        return tv;
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
