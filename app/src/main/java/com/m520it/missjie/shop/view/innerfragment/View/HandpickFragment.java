package com.m520it.missjie.shop.view.innerfragment.View;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;
import com.m520it.missjie.shop.activity.ProductDetailsActivity;
import com.m520it.missjie.shop.adapter.HandpickAdapter;
import com.m520it.missjie.shop.bean.MenBean;
import com.m520it.missjie.shop.shopcons.ShopIDiyMessage;
import com.m520it.missjie.shop.shopcons.ShopNetworkConst;
import com.m520it.missjie.shop.view.innerfragment.presenter.HandpickPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herbert
 * @time 2017/2/23 0023 下午 18:01
 * @des 精选
 */

public class HandpickFragment extends BaseFragment implements IHandpickFragment, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.choice_lv)
    ListView mChoiceLv;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeContainer;

    private HandpickAdapter mAdapter;
    protected HandpickPresenter mPresenter;

    protected View listViewHeader;
    private List<MenBean.RowsBean> rowsBeen;
    public boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_handpick, null);
        listViewHeader = inflater.inflate(R.layout.listview_header, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUI() {
        initPush();
        mAdapter = new HandpickAdapter(getContext());

        mChoiceLv.addHeaderView(listViewHeader);
        mChoiceLv.setAdapter(mAdapter);
        mChoiceLv.setDividerHeight(1);
        mChoiceLv.setDivider(new ColorDrawable(Color.GRAY));
        mAdapter.notifyDataSetChanged();
    }

    private void initPush() {
        mSwipeContainer.setOnRefreshListener(this);
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeContainer.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeContainer.setSize(SwipeRefreshLayout.LARGE); // 设置圆圈的大小

    }

    @Override
    protected void initPresenter() {
        //初始化精选的presenter
        mPresenter = new HandpickPresenter(this);
        mAdapter.notifyDataSetChanged();
        //Log.v("xmg", "url  " + ShopNetworkConst.SHOP_BASE_URL + "/searchProduct");
        mPresenter.doGetRequest(ShopIDiyMessage.HANDPICK_ACTION, ShopNetworkConst.SHOP_BASE_URL + "/searchProduct", getContext());
    }

    @Override
    protected void initListener() {
        
        mChoiceLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.v("xmg", "id  "+ id);
                if(position==0) {
                    return;
                }
                //1.拿到商品的id
                long pId = mAdapter.getItemId(position);
                //2.跳转到商品详情页
                Intent intent=new Intent(getContext(),ProductDetailsActivity.class);
                intent.putExtra(ProductDetailsActivity.PID_KEY, pId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showData(List<MenBean.RowsBean> rowsBeen) {
        if(flag== false) {
            flag=true;
            return;
        }
        mAdapter.setDatas(rowsBeen);
        mAdapter.notifyDataSetChanged();
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        flag=false;
        mPresenter.doGetRequest(ShopIDiyMessage.HANDPICK_ACTION, ShopNetworkConst.SHOP_BASE_URL + "/searchProduct", getContext());
        mSwipeContainer.setRefreshing(false);
        //mChoiceLv.setVisibility(View.GONE);
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mChoiceLv.setVisibility(View.VISIBLE);
            }
        }, 1000); // 1秒后发送消息，停止刷新*/
    }


}
