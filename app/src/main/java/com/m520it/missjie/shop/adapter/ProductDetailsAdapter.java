package com.m520it.missjie.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m520it.missjie.shop.view.innerfragment.ProductIntroduceFragment;

import java.util.ArrayList;

/**
 * @author gezi
 * @time 2017/3/9  1:16
 * @desc ${TODD}
 */
public class ProductDetailsAdapter  extends FragmentPagerAdapter {

    private ArrayList<Fragment> mViews;

    public ProductDetailsAdapter(FragmentManager fm) {
        super(fm);
        mViews=new ArrayList<Fragment>();
        mViews.add(new ProductIntroduceFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mViews.size();
    }
}
