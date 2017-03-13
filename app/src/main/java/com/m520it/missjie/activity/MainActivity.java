package com.m520it.missjie.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.home.view.HomeFragment;
import com.m520it.missjie.latest.view.LatestFragment;
import com.m520it.missjie.my.view.MyFragment;
import com.m520it.missjie.shop.view.ShopFragment;
import com.m520it.missjie.utils.PopupMenuUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.fragment)
    FrameLayout mFragment;
    @BindView(R.id.essence_iv)
    ImageView mEssenceIv;
    @BindView(R.id.essence_tv)
    TextView mEssenceTv;
    @BindView(R.id.essence)
    LinearLayout mEssence;
    @BindView(R.id.latest_iv)
    ImageView mLatestIv;
    @BindView(R.id.latest_tv)
    TextView mLatestTv;
    @BindView(R.id.latest)
    LinearLayout mLatest;
    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.rl_click)
    RelativeLayout mRlClick;
    @BindView(R.id.special_iv)
    ImageView mSpecialIv;
    @BindView(R.id.special_tv)
    TextView mSpecialTv;
    @BindView(R.id.special)
    LinearLayout mSpecial;
    @BindView(R.id.my_iv)
    ImageView mMyIv;
    @BindView(R.id.my_tv)
    TextView mMyTv;
    @BindView(R.id.my)
    LinearLayout mMy;
    @BindView(R.id.ll)
    LinearLayout mLl;

    //private static final String TAG = "MainActivity";

    //准备数据,FragmentTabHost每个tab要展示的Fragment
    private Class[] fragmentClasses = new Class[]{HomeFragment.class, LatestFragment.class,
            ShopFragment.class, MyFragment.class};
    private HomeFragment mHomeFragment;
    private LatestFragment mLatestFragment;
    private ShopFragment mShopFragment;
    private MyFragment mMyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        initListener();

    }


    /**
     * 初始化控件
     */
    private void initUI() {
        mIvImg = (ImageView) findViewById(R.id.iv_img);
        mRlClick = (RelativeLayout) findViewById(R.id.rl_click);
        initFragment();
        initTabImage();
        //默认选中
        mEssenceIv.setImageResource(R.drawable.main_bottom_home_press);
        replaceFragment(mHomeFragment);

    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mLatestFragment = new LatestFragment();
        mShopFragment = new ShopFragment();
        mMyFragment = new MyFragment();
    }

    /**
     * 设置监听
     */
    private void initListener() {
        mRlClick.setOnClickListener(this);
        mMy.setOnClickListener(this);
        mEssence.setOnClickListener(this);
        mSpecial.setOnClickListener(this);
        mLatest.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        // 当popupWindow 正在展示的时候 按下返回键 关闭popupWindow 否则关闭activity
        if (PopupMenuUtil.getInstance()._isShowing()) {
            PopupMenuUtil.getInstance()._rlClickAction();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 处理监听事件
     */
    @Override
    public void onClick(View v) {
        //1.初始化文字颜色
        mEssenceTv.setTextColor(0xFF000000);
        mLatestTv.setTextColor(0xFF000000);
        mSpecialTv.setTextColor(0xFF000000);
        mMyTv.setTextColor(0xFF000000);
        //2.改变图片
        initTabImage();
        //3.显示Fragment
        switch (v.getId()) {
            case R.id.essence:
                mEssenceTv.setTextColor(0xFFFF2D55);
                mEssenceIv.setImageResource(R.drawable.main_bottom_home_press);
                replaceFragment(mHomeFragment);
                break;
            case R.id.latest:
                mLatestTv.setTextColor(0xFFFF2D55);
                mLatestIv.setImageResource(R.drawable.main_bottom_latest_press);
                replaceFragment(mLatestFragment);
                break;
            case R.id.rl_click:
                PopupMenuUtil.getInstance()._show(MainActivity.this, mIvImg);
                break;
            case R.id.special:
                mSpecialTv.setTextColor(0xFFFF2D55);
                mSpecialIv.setImageResource(R.drawable.main_bottom_shop_press);
                replaceFragment(mShopFragment);
                break;
            case R.id.my:
                mMyTv.setTextColor(0xFFFF2D55);
                mMyIv.setImageResource(R.drawable.main_bottom_my_press);
                replaceFragment(mMyFragment);
                break;
        }
    }

    /**
     * 初始化Tab图片
     */
    private void initTabImage() {
        mIvImg.setImageResource(R.drawable.main_bottom_writeposts_normal);
        mEssenceIv.setImageResource(R.drawable.main_bottom_home_normal);
        mLatestIv.setImageResource(R.drawable.main_bottom_latest_normal);
        mSpecialIv.setImageResource(R.drawable.main_bottom_shop_normal);
        mMyIv.setImageResource(R.drawable.main_bottom_my_normal);
    }

    private void replaceFragment(BaseFragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commitAllowingStateLoss();
    }

}
