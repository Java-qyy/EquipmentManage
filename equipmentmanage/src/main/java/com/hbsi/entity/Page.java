package com.hbsi.entity;

public class Page {
    private Integer page;
    private Integer size;
    private String queryString;

    public Page() {
    }

    public Page(Integer page, Integer size, String queryString) {
        this.page = page;
        this.size = size;
        this.queryString = queryString;
    }

    public Page(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}
