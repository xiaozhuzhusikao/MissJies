package com.m520it.missjie.latest.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.latest.bean.LatestDetailBean;
import com.m520it.missjie.latest.constant.NetworkUrl;
import com.m520it.missjie.utils.HtmlUtil;
import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Herbert
 * @time 2017/3/9 0009 上午 0:38
 * @des ${TODO}
 */
//http://news-at.zhihu.com/api/4/news/9236859跳转id
public class LatestDetailActivity extends AppCompatActivity {

    @BindView(R.id.header_image)
    ImageView mHeaderImage;              // 主题插图
    @BindView(R.id.tv_headline)
    TextView mTvHeadline;                // 文章大标题
    @BindView(R.id.tv_copyright)
    TextView mTvCopyright;               // 版权信息
    @BindView(R.id.menu_share)
    ImageView mMenuShare;
    @BindView(R.id.menu_collect)
    ImageView mMenuCollect;              // 收藏
    @BindView(R.id.menu_comment)
    ImageView mMenuComment;
    @BindView(R.id.comment_count)
    TextView mCommentCount;               // 评论数
    @BindView(R.id.menu_praise)
    ImageView mMenuPraise;                // 点赞
    @BindView(R.id.praise_count)
    TextView mPraiseCount;                 // 点赞数
    @BindView(R.id.toolbar)
    Toolbar mToolbar;                          // ToolBar控件
    @BindView(R.id.load_progress_bar)
    ProgressBar mLoadProgressBar;              // 进度条
    @BindView(R.id.wv_news_detail_container)
    FrameLayout mWebViewContainer;             // webView容器

    protected WebView mWebView;                // WebView控件


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latesdetail);
        ButterKnife.bind(this);
        initData();
        configWebView();
        initListener();

    }



    private void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        //Log.e("TAG", "id  " + id);
        //Log.e("TAG", "url  " + NetworkUrl.LATEST_DETAIL_URL + id);
        HttpHelper.getInstance(this).requestGETStringResult(NetworkUrl.LATEST_DETAIL_URL + id, new HttpStringCallBack() {
            @Override
            public void onSuccessResponse(String result) {
                //Log.e("TAG", "result  " + result);
                LatestDetailBean detailBean = JSON.parseObject(result, LatestDetailBean.class);
                Log.e("TAG", "detailBean  " + detailBean.toString());
                initUI(detailBean);
            }

            @Override
            public void onFailResponse(Exception e) {

            }
        });
    }

    private void initUI(LatestDetailBean detailBean) {
        String html = HtmlUtil.createHtmlData(detailBean.getBody(),
                detailBean.getCss(), detailBean.getJs());
        mWebView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        Glide.with(LatestDetailActivity.this)
                .load(detailBean.getImage())
                .placeholder(R.drawable.loading)
                .into(mHeaderImage);
        mTvHeadline.setText(detailBean.getTitle());
        mTvCopyright.setText(detailBean.getImage_source());
    }




    @SuppressLint("SetJavaScriptEnabled")
    private void configWebView() {
        // must is app context, otherwise will may leak memory
        mWebView = new WebView(getApplicationContext());
        mWebViewContainer.addView(mWebView);
        WebSettings settings = mWebView.getSettings();

        // 设置无图模式
        //settings.setBlockNetworkImage(SPUtil.getBoolean(Constants.SETTING_NO_IMAGE));

        // 设置离线设置
        //boolean offline = SPUtil.getBoolean(Constants.SETTING_AUTO_DOWNLOAD);
        //settings.setAppCacheEnabled(offline);
        //settings.setDomStorageEnabled(offline);
        //settings.setDatabaseEnabled(offline);

        // 设置缓存模式
        //boolean netWorkAvailable = NetWorkUtil.isNetWorkAvailable(AppUtil.getAppContext());
        //settings.setCacheMode(netWorkAvailable ? WebSettings.LOAD_DEFAULT : WebSettings.LOAD_CACHE_ONLY);

        // 设置大号字体
       /* if (SPUtil.getBoolean(Constants.SETTING_BIG_FONT)) {
            settings.setMinimumFontSize(25);
        }*/

        // 激活java script
        settings.setJavaScriptEnabled(true);

        // 充满全屏
        settings.setLoadWithOverviewMode(true);

        // 适配移动端屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        // 支持缩放
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);

        // 设置可以访问文件内容
        settings.setAllowContentAccess(true);

        // 设置夜景模式
        //mWebView.setDayOrNight(!isNightMode());
    }

    private void initListener() {
        // set webView Client
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (mLoadProgressBar != null)
                    mLoadProgressBar.setVisibility(View.GONE);
            }
        });

        // set webView chrome client
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (mLoadProgressBar != null)
                    mLoadProgressBar.setProgress(newProgress);
            }
        });
    }
}
