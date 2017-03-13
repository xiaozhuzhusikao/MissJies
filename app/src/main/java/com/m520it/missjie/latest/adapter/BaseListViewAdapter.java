package com.m520it.missjie.latest.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/8 0008 下午 14:55
 * @des ${TODO}
 */

abstract class BaseListViewAdapter<T> extends BaseAdapter {

    protected List<T> mDatas;
    protected Context mContext;

    public BaseListViewAdapter(Context context) {
        mContext=context;
    }

    public void setDatas(List<T> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
