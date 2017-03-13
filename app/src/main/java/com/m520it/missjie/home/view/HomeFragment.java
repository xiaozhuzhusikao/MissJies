package com.m520it.missjie.home.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.factory.HomeFragmentFactory;
import com.m520it.missjie.home.adapter.SmartTabLayoutAdapter;
import com.m520it.missjie.home.presenter.HomePresenter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.m520it.missjie.factory.HomeFragmentFactory.HOME1_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME2_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME3_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME4_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME5_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME6_FRAGMENT;
import static com.m520it.missjie.factory.HomeFragmentFactory.HOME7_FRAGMENT;

/**
 * @author Herbert
 * @time 2017/2/21 0021 下午 19:53
 * @des ${TODO}
 */

public class HomeFragment extends BaseFragment implements IHomeFragment, View.OnClickListener {
    @BindView(R.id.cup)
    ImageView mCup;
    @BindView(R.id.mid)
    ImageView mMid;
    @BindView(R.id.refresh)
    ImageView mRefresh;
    @BindView(R.id.suiji)
    ImageView mSuiji;
    @BindView(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private HomePresenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void initUI() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragmentFactory.createFragment(HOME1_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME2_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME3_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME4_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME5_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME6_FRAGMENT));
        fragments.add(HomeFragmentFactory.createFragment(HOME7_FRAGMENT));
        String[] titles = getResources().getStringArray(R.array.home_table_titles);
        SmartTabLayoutAdapter adapter = new SmartTabLayoutAdapter(getChildFragmentManager(),fragments,titles);
        mViewPager.setAdapter(adapter);
        mViewpagertab.setViewPager(mViewPager);
    }

    @Override
    protected void initPresenter() {
        //聘用了一个秘书	并且告诉秘书 this才是老板
        mPresenter = new HomePresenter(this);
    }

    @Override
    protected void initListener() {
        mCup.setOnClickListener(this);
        mMid.setOnClickListener(this);
        mSuiji.setOnClickListener(this);
    }

    //处理点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cup:

                break;
            case R.id.mid:

                break;
            case R.id.refresh:

                break;
        }
    }
}
