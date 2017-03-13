package com.m520it.missjie.latest.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.constant.IDiyMessage;
import com.m520it.missjie.constant.NetworkConst;
import com.m520it.missjie.latest.activity.LatestListActivity;
import com.m520it.missjie.latest.adapter.LatestRvAdapter;
import com.m520it.missjie.latest.bean.LatestBean;
import com.m520it.missjie.latest.presenter.LatestPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL;

/**
 * @author Herbert
 * @time 2017/2/21 0021 下午 19:49
 * @des ${TODO}
 */

public class LatestFragment extends BaseFragment implements ILatestV {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.refresh_iv)
    ImageView mRefreshIv;
    @BindView(R.id.refresh_content)
    LinearLayout mRefreshContent;
    private LatestPresenter mPresenter;
    private LatestRvAdapter mLatestAdapter;
    private List<LatestBean.ItemBean> mDataBeans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_latest, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUI() {
        mToobar.setSubtitle("总有一姐得人心");
        mToobar.setSubtitleTextColor(Color.WHITE);
        //设置刷新动画
        mRefreshContent.setVisibility(View.VISIBLE);
        mRefreshIv.setBackgroundResource(R.drawable.refresh_imageview);
        AnimationDrawable anim = (AnimationDrawable) mRefreshIv.getBackground();
        anim.start();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, VERTICAL));
        mLatestAdapter = new LatestRvAdapter(getContext());
        mRecyclerView.setAdapter(mLatestAdapter);
    }

    @Override
    protected void initPresenter() {
        mPresenter = new LatestPresenter(this);
        mPresenter.doGetRequest(IDiyMessage.LATEST_ACTION, NetworkConst.LATEST_URL, getContext());

    }

    @Override
    protected void initListener() {
        mLatestAdapter.setItemClickListener(new LatestRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //ActivityUtil.showTip(getContext(), "position  " + position);
                //http://news-at.zhihu.com/api/3/section/1
                //Log.e("TAG","mDataBeans   "+mDataBeans.toString());
                if (mDataBeans != null) {
                    Intent intent = new Intent(getContext(), LatestListActivity.class);

                    LatestBean.ItemBean itemBean = mDataBeans.get(position);
                    int titleId = itemBean.getId();
                   // Log.e("TAG","titleId   "+titleId);
                    intent.putExtra("id", titleId);
                    getActivity().startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showUI(List<LatestBean.ItemBean> dataBeans) {
        this.mDataBeans = dataBeans;
        // Log.e("xxx", dataBeans.toString());
        mLatestAdapter.setData(dataBeans);
        mRefreshContent.setVisibility(View.GONE);
    }
}
