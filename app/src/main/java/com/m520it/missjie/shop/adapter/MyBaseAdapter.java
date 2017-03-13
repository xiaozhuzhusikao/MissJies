package com.m520it.missjie.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author gezi
 * @time 2017/2/26  15:35
 * @desc 基类adapter
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected List<T> mData;

    public void setDatas(List<T> datas) {
        //Log.v("xmg", "MyBaseAdapter mData  " + mData);
        this.mData = datas;
       // Log.v("xmg", "MyBaseAdapter datas  " + datas);
    }

    public MyBaseAdapter(Context context){
        mInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData!=null?mData.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
