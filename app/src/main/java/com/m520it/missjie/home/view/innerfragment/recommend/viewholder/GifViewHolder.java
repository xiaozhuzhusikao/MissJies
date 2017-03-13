package com.m520it.missjie.home.view.innerfragment.recommend.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.home.view.innerfragment.recommend.adapter.RecommendAdapter;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RGifBean;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RUserBean;
import com.m520it.missjie.home.view.innerfragment.recommend.customview.CircleImageView;
import com.m520it.missjie.utils.ActivityUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by kang on 2017/3/8.
 */

public class GifViewHolder extends RecommendAdapter.MessageHolder{

    @BindView(R.id.user_icon_iv)
    CircleImageView mUserIconIv;
    @BindView(R.id.username_tv)
    TextView mUsernameTv;
    @BindView(R.id.time_tv)
    TextView mTimeTv;
    @BindView(R.id.gif_text)
    TextView mGifText;
    @BindView(R.id.gif_photo_view)
    ImageView mGifPhotoView;

    @BindView(R.id.up_tv)
    TextView mUpTv;
    @BindView(R.id.down_tv)
    TextView mDownTv;
    @BindView(R.id.share_tv)
    TextView mShareTv;
    @BindView(R.id.commend_tv)
    TextView mCommendTv;

    public GifViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindHolder(RListBean bean) {
        RUserBean userBean = bean.getU();
        List<String> header = userBean.getHeader();

        Glide.with(ActivityUtil.getContext()).load(header.get(0)).into(mUserIconIv);
        mUsernameTv.setText(userBean.getName());
        mTimeTv.setText(bean.getPasstime());
        mGifText.setText(bean.getText());

        mUpTv.setText(bean.getUp());
        mDownTv.setText(bean.getDown());
        mShareTv.setText(bean.getForward());
        mCommendTv.setText(bean.getComment());

        RGifBean gif = bean.getGif();
        List<String> images = gif.getImages();
        Glide.with(ActivityUtil.getContext()).load(images.get(1)).asGif().into(mGifPhotoView);

        mUpTv.setText(bean.getUp());
        mDownTv.setText(bean.getDown());
        mShareTv.setText(bean.getForward());
        mCommendTv.setText(bean.getComment());

    }
}
