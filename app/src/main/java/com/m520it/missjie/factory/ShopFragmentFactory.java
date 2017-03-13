package com.m520it.missjie.factory;

import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.shop.view.innerfragment.ElectronicFragment;
import com.m520it.missjie.shop.view.innerfragment.FoodFragment;
import com.m520it.missjie.shop.view.innerfragment.LivingFragment;
import com.m520it.missjie.shop.view.innerfragment.MenFragment;
import com.m520it.missjie.shop.view.innerfragment.UnderwearFragment;
import com.m520it.missjie.shop.view.innerfragment.View.HandpickFragment;
import com.m520it.missjie.shop.view.innerfragment.WomenFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 17:47
 * @des ${TODO}
 */

public class ShopFragmentFactory {
    public static final int HOME1_FRAGMENT = 0;//精选
    public static final int HOME2_FRAGMENT = 1;//男装
    public static final int HOME3_FRAGMENT = 2;//居家
    public static final int HOME4_FRAGMENT = 3;//数码
    public static final int HOME5_FRAGMENT = 4;//内衣
    public static final int HOME6_FRAGMENT = 5;//美食
    public static final int HOME7_FRAGMENT = 6;//女装
    private static Map<Integer, BaseFragment> fragments = new HashMap<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment = null;
        if (fragments.containsKey(position)) {
            fragment = fragments.get(position);
            return fragment;
        }
        switch (position) {
            case HOME1_FRAGMENT://精选
                fragment = new HandpickFragment();
                break;
            case HOME2_FRAGMENT://男装
                fragment = new MenFragment();
                break;
            case HOME3_FRAGMENT://居家
                fragment = new LivingFragment();
                break;
            case HOME4_FRAGMENT://数码
                fragment = new ElectronicFragment();
                break;
            case HOME5_FRAGMENT://内衣
                fragment = new UnderwearFragment();
                break;
            case HOME6_FRAGMENT://美食
                fragment = new FoodFragment();
                break;
            case HOME7_FRAGMENT://女装
                fragment = new WomenFragment();
                break;
        }
        fragments.put(position, fragment);
        return fragment;
    }
}
