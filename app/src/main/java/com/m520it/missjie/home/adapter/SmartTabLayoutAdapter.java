package com.m520it.missjie.home.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 17:35
 * @des ${TODO}
 */

public class SmartTabLayoutAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    public SmartTabLayoutAdapter(FragmentManager fm, ArrayList<Fragment> fragments, String[] titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
        //do nothing here! no call to super.restoreState(arg0, arg1);
    }


}
