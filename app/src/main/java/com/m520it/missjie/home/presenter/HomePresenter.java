package com.m520it.missjie.home.presenter;

import android.app.Activity;
import android.content.Context;

import com.m520it.missjie.home.model.HomeModel;
import com.m520it.missjie.home.view.IHomeFragment;
import com.m520it.missjie.utils.ActivityUtil;

/**
 * @author Herbert
 * @time 2017/2/22 0022 下午 20:42
 * @des ${TODO}
 */

public class HomePresenter implements IHomePresenter {
    private IHomeFragment mView;
    private final HomeModel mModel;

    public HomePresenter(IHomeFragment view) {
        this.mView = view;
        //找到公司内部的运营部经理
        mModel = new HomeModel();
    }

    //页面跳转
    @Override
    public void startActivity(Context context, Class<? extends Activity> clz, boolean ifFinish) {
        ActivityUtil.startActivity(context, clz, ifFinish);
    }
}
