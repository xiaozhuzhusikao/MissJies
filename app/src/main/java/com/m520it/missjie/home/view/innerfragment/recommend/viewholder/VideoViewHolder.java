package com.m520it.missjie.home.view.innerfragment.recommend.viewholder;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.home.view.innerfragment.recommend.adapter.RecommendAdapter;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RUserBean;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RVideoBean;
import com.m520it.missjie.utils.ActivityUtil;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by kang on 2017/3/8.
 */

public class VideoViewHolder extends RecommendAdapter.MessageHolder{

    @BindView(R.id.user_icon_iv)
    com.m520it.missjie.home.view.innerfragment.recommend.customview.CircleImageView mUserIconIv;
    @BindView(R.id.username_tv)
    TextView mUsernameTv;
    @BindView(R.id.time_tv)
    TextView mTimeTv;
    @BindView(R.id.video_text)
    TextView mVideoText;
    @BindView(R.id.custom_videoplayer_standard)
    JCVideoPlayerStandard mCustomVideoplayerStandard;

    @BindView(R.id.up_tv)
    TextView mUpTv;
    @BindView(R.id.down_tv)
    TextView mDownTv;
    @BindView(R.id.share_tv)
    TextView mShareTv;
    @BindView(R.id.commend_tv)
    TextView mCommendTv;

    public VideoViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void bindHolder(RListBean bean) {
        RUserBean userBean = bean.getU();
        List<String> header = userBean.getHeader();

        mUpTv.setText(bean.getUp());
        mDownTv.setText(bean.getDown());
        mShareTv.setText(bean.getForward());
        mCommendTv.setText(bean.getComment());

        Glide.with(ActivityUtil.getContext()).load(header.get(0)).into(mUserIconIv);
        mUsernameTv.setText(userBean.getName());
        mTimeTv.setText(bean.getPasstime());
        mVideoText.setText(bean.getText());

        RVideoBean video = bean.getVideo();
        List<String> videoUrl = video.getVideo();
        mCustomVideoplayerStandard.setUp(videoUrl.get(0),"");
        Glide.with(ActivityUtil.getContext()).load(video.getThumbnail().get(0)).into(mCustomVideoplayerStandard.ivThumb);

    }
}
