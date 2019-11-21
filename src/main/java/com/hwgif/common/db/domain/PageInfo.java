package com.hwgif.common.db.domain;

/**
 * Created by lc.huang on 2019/4/12.
 * Description
 *
 */

import java.io.Serializable;

public class PageInfo implements Serializable {
    private static final int DEFAULT_PAGE_NO = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;
    private int page = 0;
    private int size = 10;
    private int startIndex = 0;

    public PageInfo(int page) {
        if(page < 0) {
            page = 0;
        }

        this.page = page;
        this.startIndex = page * this.size;
    }

    public PageInfo(Integer page) {
        if(null == page || page.intValue() < 0) {
            page = Integer.valueOf(0);
        }

        this.page = page.intValue();
        this.startIndex = page.intValue() * this.size;
    }

    public PageInfo(int page, int size) {
        if(page < 0) {
            page = 0;
        }

        this.page = page;
        this.size = size;
        this.startIndex = page * size;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String toString() {
        return "PageInfo{page=" + this.page + ", size=" + this.size + ", startIndex=" + this.startIndex + '}';
    }
}
