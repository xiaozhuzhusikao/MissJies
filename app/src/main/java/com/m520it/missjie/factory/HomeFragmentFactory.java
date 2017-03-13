package com.m520it.missjie.factory;

import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.home.view.innerfragment.GameFragment;
import com.m520it.missjie.home.view.innerfragment.HotFragment;
import com.m520it.missjie.home.view.innerfragment.JokeFragment;
import com.m520it.missjie.home.view.innerfragment.PictureFragment;
import com.m520it.missjie.home.view.innerfragment.RankFragment;
import com.m520it.missjie.home.view.innerfragment.recommend.view.RecommendFragment;
import com.m520it.missjie.home.view.innerfragment.VideoFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 17:47
 * @des ${TODO}
 */

public class HomeFragmentFactory {
    public static final int HOME1_FRAGMENT = 0;//推荐
    public static final int HOME2_FRAGMENT = 1;//视频
    public static final int HOME3_FRAGMENT = 2;//图片
    public static final int HOME4_FRAGMENT = 3;//段子
    public static final int HOME5_FRAGMENT = 4;//网红
    public static final int HOME6_FRAGMENT = 5;//游戏
    public static final int HOME7_FRAGMENT = 6;//排行
    private static Map<Integer, BaseFragment> fragments = new HashMap<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment = null;
        if (fragments.containsKey(position)) {
            fragment = fragments.get(position);
            return fragment;
        }
        switch (position) {
            case HOME1_FRAGMENT://推荐
                fragment = new RecommendFragment();
                break;
            case HOME2_FRAGMENT://视频
                fragment = new VideoFragment();
                break;
            case HOME3_FRAGMENT://图片
                fragment = new PictureFragment();
                break;
            case HOME4_FRAGMENT://段子
                fragment = new JokeFragment();
                break;
            case HOME5_FRAGMENT://网红
                fragment = new HotFragment();
                break;
            case HOME6_FRAGMENT://游戏
                fragment = new GameFragment();
                break;
            case HOME7_FRAGMENT://排行
                fragment = new RankFragment();
                break;
        }
        fragments.put(position, fragment);
        return fragment;
    }
}
