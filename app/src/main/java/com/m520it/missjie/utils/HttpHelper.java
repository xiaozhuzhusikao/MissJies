package com.m520it.missjie.utils;

import android.content.Context;
import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Herbert
 * @time 2017/1/3 0003 上午 1:16
 * @des ${TODO}
 */

public class HttpHelper {
    private static HttpHelper sHttpHelper;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    private HttpHelper(Context context) {
        mOkHttpClient = new OkHttpClient();
		//创建一个Handler,为了能够确保在主线程中handler
        //Looper  消息轮询器   参数当中,如果传递了一个Loop过来,那么这个Looper在哪个线程,这个Handler就跟哪个Thread通信
        //使用context.getMainLooper() 强制让handler与主线程通信
        mHandler = new Handler(context.getMainLooper());
    }

    //单例
    public static HttpHelper getInstance(Context context) {
        if (sHttpHelper == null) {
            synchronized (HttpHelper.class) {
                if (sHttpHelper == null) {
                    sHttpHelper = new HttpHelper(context);
                }
            }
        }
        return sHttpHelper;
    }

    public void requestGETStringResult(String url, final HttpStringCallBack callBack) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailResponse(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccessResponse(result);
                    }
                });
            }
        });
    }

}
