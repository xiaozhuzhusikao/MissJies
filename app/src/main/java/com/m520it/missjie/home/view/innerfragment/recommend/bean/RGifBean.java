package com.m520it.missjie.home.view.innerfragment.recommend.bean;

import java.util.List;

/**
 * Created by kang on 2017/3/7.
 */

public class RGifBean {

    List<String> images;

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "RGifBean{" +
                "images=" + images +
                '}';
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
