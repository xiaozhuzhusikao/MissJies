package com.m520it.missjie.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.m520it.missjie.R;

import java.util.List;

/**
 * @author gezi
 * @time 2017/3/9  13:53
 * @desc 加载版本的adapter
 */
public class ProductVersionAdapter extends BaseAdapter {
    //当前点击的索引
    private int mCurrentTabIndex=-1;
    private Context mContext;
    private List<String> mDatas;

    public ProductVersionAdapter(Context context) {
        mContext=context;
    }

    /**
     *	点击列表某个item
     */
    public void tabItem(int index){
        mCurrentTabIndex=index;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv=null;
        if (convertView == null) {
            LayoutInflater.from(mContext).inflate(R.layout.brand_lv_item_layout, parent,false);
            tv = (TextView) convertView.findViewById(R.id.brand_tv);
            convertView.setTag(tv);
        } else {
            tv = (TextView) convertView.getTag();
        }
        tv.setText(mDatas.get(position));
        tv.setSelected(position==mCurrentTabIndex);

        return convertView;
    }

    @Override
    public int getCount() {
        return mDatas!=null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas!=null?mDatas.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setDatas(List<String> datas) {
        mDatas = datas;
    }
}
