package com.m520it.missjie.shop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.m520it.missjie.factory.ShopFragmentFactory;

/**
 * @author Herbert
 * @time 2017/2/26 0026 下午 16:40
 * @des ${TODO}
 */

public class ShopFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private String[] mMain_titles;

    public ShopFragmentStatePagerAdapter(FragmentManager fm, String[] shop_titles) {
        super(fm);
        mMain_titles = shop_titles;
    }

    @Override
    public Fragment getItem(int position) {
        return ShopFragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return mMain_titles != null ? mMain_titles.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMain_titles[position];
    }
}
