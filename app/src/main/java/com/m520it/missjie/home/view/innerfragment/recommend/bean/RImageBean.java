package com.m520it.missjie.home.view.innerfragment.recommend.bean;

import java.util.List;

/**
 * Created by kang on 2017/3/7.
 */

public class RImageBean {

    List<String> big;

    List<String> thumbnail_small;

    public List<String> getBig() {
        return big;
    }

    public void setBig(List<String> big) {
        this.big = big;
    }

    public List<String> getThumbnail_small() {
        return thumbnail_small;
    }

    public void setThumbnail_small(List<String> thumbnail_small) {
        this.thumbnail_small = thumbnail_small;
    }

    @Override
    public String toString() {
        return "RImageBean{" +
                "big=" + big +
                ", thumbnail_small=" + thumbnail_small +
                '}';
    }
}
