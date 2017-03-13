package com.m520it.missjie.shop.view.innerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.shop.adapter.MenAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 18:01
 * @des 男装
 */

public class MenFragment extends BaseFragment {

    @BindView(R.id.men_lv)
    ListView mMenLv;
    private MenAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_men, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUI() {
        mAdapter = new MenAdapter(getContext());
        mMenLv.setAdapter(mAdapter);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initListener() {

    }
}