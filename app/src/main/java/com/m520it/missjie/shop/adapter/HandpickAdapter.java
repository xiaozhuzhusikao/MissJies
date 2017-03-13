package com.m520it.missjie.shop.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;
import com.m520it.missjie.shop.bean.MenBean;
import com.m520it.missjie.shop.shopcons.ShopNetworkConst;

import java.util.ArrayList;

/**
 * @author gezi
 * @time 2017/3/6  16:43
 * @desc 精选
 */
public class HandpickAdapter extends MyBaseAdapter<MenBean.RowsBean> {
    private Context mContext;
    private ArrayList<Fragment> mFragments;

    public HandpickAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public Object getItem(int position) {
        return mData!=null?mData.get(position):null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_man, parent, false);
            holder.productIv = (ImageView)convertView.findViewById(R.id.product_iv);
            holder.nameTv = (TextView) convertView.findViewById(R.id.name_tv);
            holder.priceTv = (TextView) convertView.findViewById(R.id.price_tv);
            holder.buyCountTv = (TextView) convertView.findViewById(R.id.buyCount_tv);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置数据
        MenBean.RowsBean rowsBean = mData.get(position);
        Glide
                .with(mContext)//
                .load(ShopNetworkConst.SHOP_BASE_URL + rowsBean.getIconUrl())//
                .into(holder.productIv);

        holder.priceTv.setText("$ " + rowsBean.getPrice()+"");
        holder.nameTv.setText(rowsBean.getName());
        holder.buyCountTv.setText(rowsBean.getCommentCount()+"条评价好评" +rowsBean.getFavcomRate());

        return convertView;
    }

    public class ViewHolder{
        ImageView productIv;
        TextView priceTv;
        TextView nameTv;
        TextView buyCountTv;
    }

}

