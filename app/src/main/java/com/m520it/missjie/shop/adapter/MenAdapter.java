package com.m520it.missjie.shop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m520it.missjie.R;
import com.m520it.missjie.shop.bean.MenBean;

/**
 * @author gezi
 * @time 2017/2/23  12:01
 * @desc 男装  适配器
 */
public class MenAdapter extends MyBaseAdapter<MenBean.RowsBean> {

    public MenAdapter(Context context ) {
        super(context);
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

       // holder.productIv.setImageUrl( NetWorkUrlCons.BASE_URL + rowsBean.getIconUrl());

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
