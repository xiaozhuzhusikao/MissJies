package com.m520it.missjie.latest.bean;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/8 0008 下午 15:08
 * @des ${TODO}
 */

public class LatestListBean {
    private String name;
    private List<StoryBean> stories;
    private long timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StoryBean> getStories() {
        return stories;
    }

    public void setStories(List<StoryBean> stories) {
        this.stories = stories;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LatestListBean{" +
                "name='" + name + '\'' +
                ", stories=" + stories +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class StoryBean{
        private String date;
        private String display_date;
        private int id;
        private List<String> images;
        private String title;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public void setDisplay_date(String display_date) {
            this.display_date = display_date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "StoryBean{" +
                    "date='" + date + '\'' +
                    ", display_date='" + display_date + '\'' +
                    ", id=" + id +
                    ", images=" + images +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
