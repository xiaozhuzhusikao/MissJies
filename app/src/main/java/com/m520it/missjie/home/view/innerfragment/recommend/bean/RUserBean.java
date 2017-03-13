package com.m520it.missjie.home.view.innerfragment.recommend.bean;

import java.util.List;

/**
 * Created by kang on 2017/3/7.
 */

public class RUserBean {
    //用户头像
    private List<String> header;
    //用户名称
    private String name;

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RUserBean{" +
                "header=" + header +
                ", name='" + name + '\'' +
                '}';
    }
}
