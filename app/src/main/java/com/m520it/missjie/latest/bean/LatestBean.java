package com.m520it.missjie.latest.bean;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/7 0007 下午 20:39
 * @des ${TODO}
 */

public class LatestBean {
    private List<ItemBean> data;


    public static class ItemBean {
        private String description;
        private int id;
        private String name;
        private String thumbnail;//图片url

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        @Override
        public String toString() {
            return "ItemBean{" +
                    "description='" + description + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    '}';
        }
    }

    public List<ItemBean> getData() {
        return data;
    }

    public void setData(List<ItemBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LatestBean{" +
                "data=" + data +
                '}';
    }
}

