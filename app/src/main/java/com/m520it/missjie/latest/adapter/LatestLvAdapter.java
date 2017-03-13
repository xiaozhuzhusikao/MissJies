package com.m520it.missjie.latest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.latest.bean.LatestListBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Herbert
 * @time 2017/3/8 0008 下午 14:54
 * @des ${TODO}
 */

public class LatestLvAdapter extends BaseListViewAdapter<LatestListBean.StoryBean>{
    public LatestLvAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Log.d("110", mDatas.size() + "");
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_refreshlist, parent, false);
            holder.civ = (CircleImageView) convertView.findViewById(R.id.iv_news_image);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_news_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LatestListBean.StoryBean storyBean = mDatas.get(position);
        List<String> images = storyBean.getImages();
        Glide.with(mContext)
                .load(images.get(0))
                .placeholder(R.drawable.loading)
                .into(holder.civ);
        holder.tv.setText(storyBean.getTitle());
        return convertView;
    }

    class ViewHolder {
        public CircleImageView civ;
        public TextView tv;
    }
}
