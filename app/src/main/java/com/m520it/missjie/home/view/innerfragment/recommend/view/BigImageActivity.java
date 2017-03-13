package com.m520it.missjie.home.view.innerfragment.recommend.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.m520it.missjie.R;

/**
 * Created by kang on 2017/3/8.
 */

public class BigImageActivity extends Activity {

    private ImageView mImageView;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigimage);
        // TODO: 2017/3/9
        mImageView = (ImageView) findViewById(R.id.photo_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        Glide.with(BigImageActivity.this).load(url).into(mImageView);
        /*rxSbscription=RxBus.getInstance().toObserverable(ImageEvent.class)
                .subscribe(new Action1<ImageEvent>() {
                    @Override
                    public void call(ImageEvent imageEvent) {
                        // TODO: 2017/3/9
                        String imageUrl = imageEvent.getImageUrl();

                        Log.e("m520it111--------------",imageUrl);

                        Glide.with(BigImageActivity.this).load(imageUrl).into(mImageView);

                    }
                });*/

    }

    //取消订阅
    @Override
    protected void onDestroy() {
        /*if (!rxSbscription.isUnsubscribed()){
            rxSbscription.unsubscribe();
        }*/
        super.onDestroy();
    }
}
