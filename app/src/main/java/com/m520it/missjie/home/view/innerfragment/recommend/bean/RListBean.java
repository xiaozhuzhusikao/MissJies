package com.m520it.missjie.home.view.innerfragment.recommend.bean;

/**
 * Created by kang on 2017/3/6.
 */

public class RListBean {
    //评论数
    private String comment;
    //不支持数
    private String down;
    //赞的数
    private String up;
    //帖子的文本内容
    private String text;

    //帖子的类型//video,image,gif,text
    private String type;

    //发帖子的时间
    private String passtime;
    //分享人数
    private String forward;


    //分享的帖子url
    //private String share_url;

    //用户信息 JSONString
    private RUserBean u;

    //视频Bean
    private RVideoBean video;

    //图片Bean
    private RImageBean image;

    //动态图片
    private RGifBean gif;



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }


    public RUserBean getU() {
        return u;
    }

    public void setU(RUserBean u) {
        this.u = u;
    }

    public RVideoBean getVideo() {
        return video;
    }

    public void setVideo(RVideoBean video) {
        this.video = video;
    }

    public RImageBean getImage() {
        return image;
    }

    public void setImage(RImageBean image) {
        this.image = image;
    }

    public RGifBean getGif() {
        return gif;
    }

    public void setGif(RGifBean gif) {
        this.gif = gif;
    }

    @Override
    public String toString() {
        return "RListBean{" +
                "comment='" + comment + '\'' +
                ", down='" + down + '\'' +
                ", up='" + up + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", passtime='" + passtime + '\'' +
                ", forward='" + forward + '\'' +
                ", u=" + u +
                ", video=" + video +
                ", image=" + image +
                ", gif=" + gif +
                '}'+"----------------";
    }
}
