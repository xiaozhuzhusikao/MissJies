package com.m520it.missjie.utils;

/**
 * @author Herbert
 * @time 2017/1/3 0003 上午 1:27
 * @des ${TODO}
 */

public interface HttpStringCallBack {
    //响应成功
    void onSuccessResponse(String result);

    //响应失败
    void onFailResponse(Exception e);
}
