package com.m520it.missjie.home.view.innerfragment.recommend.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.home.view.innerfragment.recommend.adapter.RecommendAdapter;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RUserBean;
import com.m520it.missjie.home.view.innerfragment.recommend.customview.CircleImageView;
import com.m520it.missjie.home.view.innerfragment.recommend.view.BigImageActivity;
import com.m520it.missjie.utils.ActivityUtil;

import java.util.List;

import butterknife.BindView;


/**
 * Created by kang on 2017/3/8.
 */

public class ImageViewHolder extends RecommendAdapter.MessageHolder{

    private final Context mContext;
    @BindView(R.id.user_icon_iv)
    CircleImageView mUserIconIv;
    @BindView(R.id.username_tv)
    TextView mUsernameTv;
    @BindView(R.id.time_tv)
    TextView mTimeTv;
    @BindView(R.id.image_text)
    TextView mImageText;
    @BindView(R.id.image_photo_view)
    ImageView mImagePhotoView;

    @BindView(R.id.up_tv)
    TextView mUpTv;
    @BindView(R.id.down_tv)
    TextView mDownTv;
    @BindView(R.id.share_tv)
    TextView mShareTv;
    @BindView(R.id.commend_tv)
    TextView mCommendTv;

    @BindView(R.id.image_rl)
    RelativeLayout mImageRl;

    public ImageViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
    }

    @Override
    public void bindHolder(final RListBean bean) {
        RUserBean userBean = bean.getU();
        List<String> header = userBean.getHeader();

        mUpTv.setText(bean.getUp());
        mDownTv.setText(bean.getDown());
        mShareTv.setText(bean.getForward());
        mCommendTv.setText(bean.getComment());

        Glide.with(ActivityUtil.getContext()).load(header.get(0)).into(mUserIconIv);
        mUsernameTv.setText(userBean.getName());
        mTimeTv.setText(bean.getPasstime());
        mImageText.setText(bean.getText());

        //bean.getImage()长图片
        List<String> thumbnail_small = bean.getImage().getThumbnail_small();
        Glide.with(ActivityUtil.getContext()).load(thumbnail_small.get(0)).into(mImagePhotoView);

        mImageRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> big = bean.getImage().getBig();
                String bigImage = big.get(0);

                Intent intent = new Intent(ActivityUtil.getContext(), BigImageActivity.class);
                intent.putExtra("URL",bigImage);
                mContext.startActivity(intent);


                /*//把图片的URL通过RXBus发送出去
                RxBus.getInstance().post(new ImageEvent(bigImage));
                Log.e("m520it--------------",bigImage);*/

            }
        });
    }
}
