package com.m520it.missjie.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.m520it.missjie.R;
import com.m520it.missjie.shop.adapter.OnPageChangeListenerAdapter;
import com.m520it.missjie.shop.adapter.ProductBannerAdapter;
import com.m520it.missjie.shop.adapter.ProductDetailsAdapter;
import com.m520it.missjie.shop.adapter.ProductVersionAdapter;
import com.m520it.missjie.shop.bean.ProductDetailBean;
import com.m520it.missjie.shop.view.innerfragment.controller.ProductController;
import com.m520it.missjie.utils.ActivityUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author gezi
 * @time 2017/3/8  19:50
 * @desc 商品详情页面
 */
public class ProductDetailsActivity extends FragmentActivity implements IProductListener, AdapterView.OnItemClickListener {

    @BindView(R.id.introduce_view)
    View mIntroduceView;
    @BindView(R.id.introduce_ll)
    LinearLayout mIntroduceLl;
    @BindView(R.id.more_iv)
    ImageView mMoreIv;
    //图片
    @BindView(R.id.asvp)
    ViewPager mAsvp;
    //轮播图指示器的数字
    @BindView(R.id.vp_indic_tv)
    TextView mVpIndicTv;
    //名字
    @BindView(R.id.name_tv)
    TextView mNameTv;
    //是否自营
    @BindView(R.id.self_sale_tv)
    TextView mSelfSaleTv;
    //
    @BindView(R.id.recommand_product_tv)
    TextView mRecommandProductTv;
    //数量
    @BindView(R.id.recommend_buy_tv)
    TextView mRecommendBuyTv;
    //价格
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

    private long mProductId;
    private ProductController mController;
    private ProductDetailsAdapter mContainerAdapter;

    private ProductBannerAdapter mBannerAdapter;

    public static final String PID_KEY = "pid";
    private Timer mTimer;
    private ProductVersionAdapter mProductVersionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_productdetail_list);
        ButterKnife.bind(this);
        initData();
        initController();
        initUI();
    }

    private void initUI() {
        mContainerAdapter = new ProductDetailsAdapter(getSupportFragmentManager());
        /**
         * 商品图片的adapter
         */
        mBannerAdapter = new ProductBannerAdapter(getApplicationContext());
        mAsvp.setAdapter(mBannerAdapter);
        /**
         * 设置当图片滚动时候的指示器的指示字体的变化
         */
        mAsvp.setOnPageChangeListener(new OnPageChangeListenerAdapter() {
            @Override
            public void onPageSelected(int position) {
                mVpIndicTv.setText((position+1)+"/"+mBannerAdapter.getCount());
            }
        });

        /**
         * 商品版本信息的adapter
         */
//        mProductVersionAdapter = new ProductVersionAdapter(getApplicationContext());
//        mProductVersionsLv.setAdapter(mProductVersionAdapter);
//        mProductVersionsLv.setOnItemClickListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        mProductId = intent.getLongExtra(PID_KEY, 0);
        if (mProductId == 0) {
            ActivityUtil.showTip(this, "数据异常!");
            finish();
        }
    }

    private void initController() {

        mController = new ProductController(this,this);
        ProductDetailBean.ResultBean productDetailBean = mController.loadProductInfo(mProductId);

    }

    @Override
    public void showData(ProductDetailBean.ResultBean resultBeen) {
        if (resultBeen.toString()==null) {
            ActivityUtil.showTip(this, "数据异常!");
            this.finish();
            return;
        }
        //加载商品的图片
        loadProductBanner(resultBeen.getImgUrls());
        //加载商品的基础数据
        mNameTv.setText(resultBeen.getName());
        mSelfSaleTv.setVisibility(resultBeen.isIfSaleOneself()?View.VISIBLE:View.GONE);
        mRecommandProductTv.setText(resultBeen.getRecomProduct());
        mRecommendBuyTv.setTag(resultBeen.getRecomProductId());
        mFavRateTv.setText(resultBeen.getFavcomRate()+"%好评");
        mCommentCountTv.setText(resultBeen.getCommentCount()+"人评价");

        //加载商品的型号列表
        handleProductVersion(resultBeen.getTypeList());
        //为输入框设置库存的最大限度
//        mNumberInputView.setMax(resultBeen.getStockCount());
        //设置评论
    }

    private void handleProductVersion(List<String> typeList){
//        mProductVersionAdapter.setDatas(typeList);
//        mProductVersionAdapter.notifyDataSetChanged();
    }

    /**
     * 处理展示的商品图片
     */
    private void loadProductBanner(final List<String> imgUrls) {
        mBannerAdapter.setDatas(imgUrls);
        mBannerAdapter.notifyDataSetChanged();
        //加载图片的指示器
        mVpIndicTv.setText("1/"+imgUrls.size());
        //开始让图片自己滚动
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        int currentItem = mAsvp.getCurrentItem();
                        currentItem++;
                        if (currentItem>imgUrls.size()-1) {
                            currentItem=0;
                        }
                        mAsvp.setCurrentItem(currentItem,true);
                    }
                });
            }
        }, 3000,3000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //该代码是修改界面的UI
        mProductVersionAdapter.tabItem(position);
        //1.点击列表 获取当前的选择的item字符串
        String pVersion = (String) mProductVersionAdapter.getItem(position);
        //2.找到对应的Activity
       //ProductDetailsActivity activity = (ProductDetailsActivity) getActivity();
        //activity.mProductVersion=pVersion;
    }

   public void goBack(View view){
       this.finish();
   }
    public void add2ShopCar(View view){
        Toast.makeText(ProductDetailsActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
    }
}
