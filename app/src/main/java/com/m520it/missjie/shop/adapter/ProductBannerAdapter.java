package com.m520it.missjie.shop.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.bumptech.glide.Glide;
import com.m520it.missjie.shop.shopcons.ShopNetworkConst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gezi
 * @time 2017/3/9  11:40
 * @desc ${TODD}
 */
public class ProductBannerAdapter extends PagerAdapter {

    private Context mContext;
    protected ArrayList<Object> mViews;

    public ProductBannerAdapter(Context c) {
        mContext = c;
    }

    public void setDatas(List<String> datas) {
        mViews = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            ImageView img = new ImageView(mContext);
            LayoutParams params = new ViewGroup.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            img.setLayoutParams(params);
            img.setScaleType(ScaleType.FIT_XY);
            Glide
                    .with(mContext)
                    .load(ShopNetworkConst.SHOP_BASE_URL + datas.get(i))
                    .into(img);

            mViews.add(img);
        }
    }


    @Override
    public int getCount() {

        return mViews == null ? 0 : mViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView smiv = (ImageView) mViews.get(position);
        container.addView(smiv);
        return smiv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView smiv = (ImageView) mViews.get(position);
        container.removeView(smiv);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}
