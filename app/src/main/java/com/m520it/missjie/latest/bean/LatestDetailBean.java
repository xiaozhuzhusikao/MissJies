package com.m520it.missjie.latest.bean;

import java.util.List;

/**
 * @author Herbert
 * @time 2017/3/9 0009 上午 8:58
 * @des ${TODO}
 */

public class LatestDetailBean {
    private String body;
    private List<String> css;//样式

    private String ga_prefix;
    private int id;
    private String image;//小图片
    private String image_source;
    private String title;//标题
    private List<String> images;//大图片
    private  List<String> js;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getJs() {
        return js;
    }

    public void setJs(List<String> js) {
        this.js = js;
    }

    @Override
    public String toString() {
        return "LatestDetailBean{" +
                "body='" + body + '\'' +
                ", css=" + css +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", id=" + id +
                ", image='" + image + '\'' +
                ", image_source='" + image_source + '\'' +
                ", images=" + images +
                ", js=" + js +
                '}';
    }

    public static class SectionBean{
        private String share_url;
        private String title;
        private int type;

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "SectionBean{" +
                    "share_url='" + share_url + '\'' +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

}
