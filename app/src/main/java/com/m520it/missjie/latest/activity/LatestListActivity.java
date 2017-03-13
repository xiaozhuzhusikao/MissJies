package com.m520it.missjie.latest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.m520it.missjie.R;
import com.m520it.missjie.latest.adapter.LatestLvAdapter;
import com.m520it.missjie.latest.bean.LatestListBean;
import com.m520it.missjie.latest.constant.NetworkUrl;
import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herbert
 * @time 2017/3/8 0008 上午 11:24
 * @des ${TODO}
 */


public class LatestListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.lv_news)
    ListView mLvNews;
    @BindView(R.id.pull_refresh_view)
    SwipeRefreshLayout mPullRefreshView;
    private List<LatestListBean.StoryBean> mStories;
    private LatestLvAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latestlist);
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    private void initView() {
            // set pull refresh UI's color style
        mPullRefreshView.setColorSchemeResources(android.R.color.holo_blue_light,
                    android.R.color.holo_red_light, android.R.color.holo_orange_light,
                    android.R.color.holo_green_light);

        mPullRefreshView.setOnRefreshListener(this);
    }

    /*----------初始化界面----------*/
    private void initUI() {
        mAdapter = new LatestLvAdapter(this);
        mLvNews.setAdapter(mAdapter);
        // Log.e("TAG", "我来过");
        mAdapter.setDatas(mStories);


    }

    /*----------初始化数据----------*/
    private void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        //Log.e("TAG", "id  " + id);
        //Log.e("TAG", "url  " + NetworkUrl.LATEST_LIST_URL + id);
        HttpHelper.getInstance(this).requestGETStringResult(NetworkUrl.LATEST_LIST_URL + id, new HttpStringCallBack() {
            @Override
            public void onSuccessResponse(String result) {
                //Log.e("TAG", "result  " + result);
                LatestListBean listBean = JSON.parseObject(result, LatestListBean.class);
                mStories = listBean.getStories();
                if (mStories != null) {
                    initUI();
                }
                // Log.e("TAG", "listBean  " + mStories.toString());
            }

            @Override
            public void onFailResponse(Exception e) {

            }
        });
    }

    /*----------ListView的item设置监听----------*/
    private void initListener() {
        mLvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LatestListActivity.this, LatestDetailActivity.class);
                LatestListBean.StoryBean storyBean = mStories.get(position);
                int titleId = storyBean.getId();
                // Log.e("TAG","titleId   "+titleId);
                intent.putExtra("id", titleId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        initData();
        mPullRefreshView.setRefreshing(false);
    }
}
