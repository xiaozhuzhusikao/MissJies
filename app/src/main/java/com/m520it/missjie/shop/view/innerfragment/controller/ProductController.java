package com.m520it.missjie.shop.view.innerfragment.controller;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.m520it.missjie.shop.activity.IProductListener;
import com.m520it.missjie.shop.bean.ProductDetailBean;
import com.m520it.missjie.shop.shopcons.ShopNetworkConst;
import com.m520it.missjie.utils.HttpHelper;
import com.m520it.missjie.utils.HttpStringCallBack;

/**
 * @author gezi
 * @time 2017/3/9  0:48
 * @desc ${TODD}
 */
public class ProductController {
    public Context mContext;

    protected IProductListener mListener;

    public ProductController(Context context, IProductListener listener) {
        mContext=context;
        mListener=listener;
    }

    /**
     * @param pid
     * @return 如果找不到对象 则返回null
     */
    public ProductDetailBean.ResultBean loadProductInfo(long pid) {
        HttpHelper.getInstance(mContext).requestGETStringResult(ShopNetworkConst.PRODUCT_DETAIL+"id="+pid, new HttpStringCallBack() {
            @Override
            public void onSuccessResponse(String result) {
                ProductDetailBean Bean = JSON.parseObject(result,ProductDetailBean.class);

                ProductDetailBean.ResultBean resultBean = JSONArray.parseObject(Bean.getResult(), ProductDetailBean.ResultBean.class);
//                Log.v("xmg", "data " + resultBean.toString());
                mListener.showData(resultBean);
            }

            @Override
            public void onFailResponse(Exception e) {

            }
        });
        return null;
    }
    public void setIModelChangeListener(IProductListener listener) {
        mListener=listener;
    }

}
