package com.m520it.missjie.shop.view.innerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.m520it.missjie.R;
import com.m520it.missjie.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author gezi
 * @time 2017/3/9  1:17
 * @desc ${TODD}
 */
public class ProductIntroduceFragment extends BaseFragment {

    @BindView(R.id.asvp)
    ViewPager mAsvp;
    @BindView(R.id.vp_indic_tv)
    TextView mVpIndicTv;
    @BindView(R.id.name_tv)
    TextView mNameTv;
    @BindView(R.id.self_sale_tv)
    TextView mSelfSaleTv;
    @BindView(R.id.recommand_product_tv)
    TextView mRecommandProductTv;
    @BindView(R.id.recommend_buy_tv)
    TextView mRecommendBuyTv;
    @BindView(R.id.price_tv)
    TextView mPriceTv;
    @BindView(R.id.tip_tv)
    TextView mTipTv;
    @BindView(R.id.product_versions_lv)
    ListView mProductVersionsLv;
    @BindView(R.id.decrease_count)
    ImageView mDecreaseCount;
    @BindView(R.id.number_et)
    EditText mNumberEt;
    @BindView(R.id.increase_count)
    ImageView mIncreaseCount;
    @BindView(R.id.good_rate_tip)
    TextView mGoodRateTip;
    @BindView(R.id.fav_rate_tv)
    TextView mFavRateTv;
    @BindView(R.id.comment_count_tv)
    TextView mCommentCountTv;
    @BindView(R.id.good_comment_lv)
    ListView mGoodCommentLv;
    @BindView(R.id.scrollview)
    ScrollView mScrollview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_introduce, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initPresenter() {
        //做网络请求

    }

    @Override
    protected void initListener() {

    }
}

