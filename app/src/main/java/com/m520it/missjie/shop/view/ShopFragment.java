package com.m520it.missjie.shop.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.astuetz.PagerSlidingTabStripCopy;
import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.shop.adapter.ShopFragmentStatePagerAdapter;
import com.m520it.missjie.shop.presenter.ShopPresenter;
import com.m520it.missjie.utils.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herbert
 * @time 2017/2/21 0021 下午 19:49
 * @des 败家姐的侧滑实现
 */

public class ShopFragment extends BaseFragment implements View.OnClickListener,IShopFragment{

    @BindView(R.id.myshop)
    ImageView mMyshop;
    @BindView(R.id.shopcar)
    ImageView mShopcar;
    @BindView(R.id.main_pagersliding)
    PagerSlidingTabStripCopy mMainPagersliding;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.icon_dingdan)
    ImageView mIconDingdan;
    @BindView(R.id.first)
    RelativeLayout mFirst;
    @BindView(R.id.icon_gouwuche)
    ImageView mIconGouwuche;
    @BindView(R.id.second)
    RelativeLayout mSecond;
    @BindView(R.id.icon_zuji)
    ImageView mIconZuji;
    @BindView(R.id.threa)
    RelativeLayout mThrea;
    @BindView(R.id.icon_fankui)
    ImageView mIconFankui;
    @BindView(R.id.four)
    RelativeLayout mFour;
    @BindView(R.id.icon_shouquan)
    ImageView mIconShouquan;
    @BindView(R.id.kanqi)
    ImageView mKanqi;
    @BindView(R.id.five)
    RelativeLayout mFive;
    @BindView(R.id.slidemenu)
    FrameLayout mSlidemenu;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;

    private ShopPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void initUI() {
        String[] shop_titles = ActivityUtil.getStringArr(R.array.shop_titles);
        //设置ViewPager
        ShopFragmentStatePagerAdapter adapter = new ShopFragmentStatePagerAdapter(getFragmentManager(), shop_titles);
        mViewPager.setAdapter(adapter);
        //设置PagerSlidingTab
        mMainPagersliding.setViewPager(mViewPager);
        //初始化侧滑菜单
        initSlideMenu();
    }

    private void initSlideMenu() {
        mFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.showTip(getActivity(), "我的订单");
                mDrawer.closeDrawer(Gravity.LEFT);
            }
        });
        mSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.showTip(getActivity(), "购物车");
                mDrawer.closeDrawer(Gravity.LEFT);
            }
        });
        mThrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.showTip(ActivityUtil.getContext(), "我的足迹");
                mDrawer.closeDrawer(Gravity.LEFT);
            }
        });
        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.showTip(ActivityUtil.getContext(), "购物反馈");
                mDrawer.closeDrawer(Gravity.LEFT);
            }
        });
        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.showTip(ActivityUtil.getContext(), "账号授权");
                mDrawer.closeDrawer(Gravity.LEFT);
            }
        });
    }

    @Override
    protected void initPresenter() {
        //聘用了一个秘书	并且告诉秘书 this才是老板
        mPresenter = new ShopPresenter(this);
    }

    @Override
    protected void initListener() {
        mMyshop.setOnClickListener(this);
        mShopcar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myshop:
                mDrawer.openDrawer(Gravity.LEFT);
                break;
        }
    }


}
