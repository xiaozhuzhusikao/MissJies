package com.m520it.missjie.latest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.latest.bean.LatestBean;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/6 0006 下午 16:59
 * @des ${TODO}
 */

public class LatestRvAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List mData;

    /*点击事件*/
    private OnItemClickListener mListener;

    /*事件监听接口*/
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    /**
     * 设置事件单击监听器
     */
    public void setItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public LatestRvAdapter(Context context) {
        mContext = context;
    }

    public void setData(List datas) {
        mData = datas;
        notifyDataSetChanged();
    }


    public void addDatas(List datas) {
        mData.addAll(datas);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_latest, parent, false);
        LatestViewHolder holder = new LatestViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        LatestBean.ItemBean itemBean = (LatestBean.ItemBean) mData.get(position);
        Glide.with(mContext)
                .load(itemBean.getThumbnail())
                .into(((LatestViewHolder) holder).mImageView);
        ((LatestViewHolder) holder).TextView.setText(itemBean.getName());
        ((LatestViewHolder) holder).mDesTv.setText(itemBean.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                Toast.makeText(mContext, "点击了item"+position, Toast.LENGTH_SHORT).show();
                mListener.onItemClick(holder.itemView, position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class LatestViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView TextView;
        private TextView mDesTv;

        public LatestViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_section);
            TextView = (TextView) itemView.findViewById(R.id.title_section);
            mDesTv = (TextView) itemView.findViewById(R.id.description_section);
        }
    }
}
