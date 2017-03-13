package com.m520it.missjie.home.view.innerfragment.recommend.adapter;

import android.view.View;

import com.m520it.missjie.R;
import com.m520it.missjie.home.view.innerfragment.recommend.bean.RListBean;
import com.m520it.missjie.home.view.innerfragment.recommend.viewholder.GifViewHolder;
import com.m520it.missjie.home.view.innerfragment.recommend.viewholder.ImageViewHolder;
import com.m520it.missjie.home.view.innerfragment.recommend.viewholder.TextViewHolder;
import com.m520it.missjie.home.view.innerfragment.recommend.viewholder.VideoViewHolder;

/**
 * Created by kang on 2017/3/7.
 */

public class RecommendAdapter extends BaseRecyclerViewAdapter<RListBean> {

    public static final int TYPE_VIDEO = 1;

    public static final int TYPE_GIF = 2;

    public static final int TYPE_IMAGE = 3;

    public static final int TYPE_TEXT = 4;

    //不同的item要复写的方法
    @Override
    public int getItemType(int index) {
        RListBean bean = (RListBean) mDatas.get(index);
        String type = bean.getType();
        if ("video".equals(type)) {
            return TYPE_VIDEO;
        } else if ("gif".equals(type)) {
            return TYPE_GIF;
        } else if ("image".equals(type)) {
            return TYPE_IMAGE;
        }else{
            return TYPE_TEXT;
        }
    }

    @Override
    protected int getLayoutId(int viewType) {
        if (viewType == TYPE_VIDEO) {
            return R.layout.recom_recycler_item_video;
        } else if (viewType == TYPE_GIF) {
            return R.layout.recom_recycle_item_gif;
        } else if (viewType == TYPE_IMAGE) {
            return R.layout.recom_recycle_item_image;
        } else {
            return R.layout.recom_recycle_item_text;
        }
    }

    @Override
    protected BaseHolder<RListBean> creatHolder(View view, int viewType) {
        switch (viewType) {
            case TYPE_VIDEO:
                return new VideoViewHolder(view);
            case TYPE_GIF:
                return new GifViewHolder(view);
            case TYPE_IMAGE:
                return new ImageViewHolder(view);
            default:
                return new TextViewHolder(view);
        }
    }

    public static abstract class MessageHolder extends BaseHolder<RListBean> {

        public MessageHolder(View itemView) {
            super(itemView);
        }

        @Override
        public abstract void bindHolder(RListBean bean);
    }

}
