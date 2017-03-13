package com.m520it.missjie.home.view.innerfragment.recommend.bean;

import java.util.List;

/**
 * Created by kang on 2017/3/7.
 */

public class RVideoBean {

    private List<String> thumbnail;

    private List<String> video;

    public List<String> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(List<String> thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "RVideo{" +
                "thumbnail=" + thumbnail +
                ", video=" + video +
                '}';
    }
}
