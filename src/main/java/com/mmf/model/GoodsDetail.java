package com.mmf.model;

import java.util.List;

/**
 * Created by MMF on 2017/6/14.
 */
public class GoodsDetail {
    private int id;
    private String title;
    private String describe;
    private String rental;
    private String deposit;
    private List<String>  pathList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public List<String> getPathList() {
        return pathList;
    }

    public void setPathList(List<String> pathList) {
        this.pathList = pathList;
    }
}
