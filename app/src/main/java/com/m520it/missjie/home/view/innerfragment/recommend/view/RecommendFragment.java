package com.m520it.missjie.home.view.innerfragment.recommend.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.constant.IDiyMessage;
import com.m520it.missjie.constant.NetworkConst;
import com.m520it.missjie.home.view.innerfragment.recommend.adapter.RecommendAdapter;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.customview.DividerItemDecoration;
import com.m520it.missjie.home.view.innerfragment.recommend.presenter.RecommendPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 18:01
 * @des ${TODO}
 */

public class RecommendFragment extends BaseFragment implements View.OnClickListener, IRecommendV {

    @BindView(R.id.banner_iv)
    ImageView mBannerIv;
    @BindView(R.id.recommend_recyclerView)
    RecyclerView mRecommendRecyclerView;
    @BindView(R.id.refresh_iv)
    ImageView mRefreshIv;
    @BindView(R.id.refresh_content)
    LinearLayout mRefreshContent;
    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshWidget;
    private RecommendPresenter mPresenter;
    private List<RListBean> mDatas;
    private RecommendAdapter mRecommendAdapter;
    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUI() {
        Glide.with(getContext())
                .load(NetworkConst.BANNER_URL)
                .into(mBannerIv);
        mLayoutManager = new LinearLayoutManager(getContext());


        mRecommendRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecommendRecyclerView.setHasFixedSize(true);
        //创建并设置Adapter
        mRecommendRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线

        mRecommendRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL_LIST));
        //设置adapter
        mRecommendAdapter = new RecommendAdapter();

        //设置下拉刷新
        setReflash();
    }

    private void setReflash() {
        //设置下拉出现小圆圈是否是缩放出现，出现的位置，最大的下拉位置
        mSwipeRefreshWidget.setProgressViewOffset(true, 0, 50);
        //设置下拉圆圈的大小，两个值 LARGE， DEFAULT
        mSwipeRefreshWidget.setSize(SwipeRefreshLayout.DEFAULT);
        // 设定下拉圆圈的背景
        mSwipeRefreshWidget.setProgressBackgroundColor(R.color.touming);

        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeRefreshWidget.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.doGetRequest(IDiyMessage.RECOMMEND_ACTION, NetworkConst.RECOMMEND_URL, getContext());
                mRecommendAdapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        mSwipeRefreshWidget.setRefreshing(false);
                    }
                }, 4000);
            }
        });


    }

    @Override
    protected void initPresenter() {
        //设置进入刷新动画
        mRefreshContent.setVisibility(View.VISIBLE);
        mRefreshIv.setBackgroundResource(R.drawable.refresh_imageview);
        AnimationDrawable anim = (AnimationDrawable) mRefreshIv.getBackground();
        anim.start();

        mPresenter = new RecommendPresenter(this);
        //请求网络
        mPresenter.doGetRequest(IDiyMessage.RECOMMEND_ACTION, NetworkConst.RECOMMEND_URL, getContext());
    }

    @Override
    protected void initListener() {
        mBannerIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_iv://跳转到败家姐页面

                break;
        }
    }


    @Override
    public void showRv(List rListBeens) {
        mRefreshContent.setVisibility(View.GONE);
        mDatas = rListBeens;

        mRecommendAdapter.setData(mDatas);
        mRecommendRecyclerView.setAdapter(mRecommendAdapter);

    }

    @Override
    public void onPause() {
        JCVideoPlayer.releaseAllVideos();
        super.onPause();
    }
}
