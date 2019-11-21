package com.hwgif.common.db.domain;

/**
 * Created by lc.huang on 2019/4/12.
 * Description
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageControl<T> implements Serializable {
    private int number;
    private int size;
    private long total;
    private List<T> content = new ArrayList();

    public PageControl() {
    }

    public List<T> getContent() {
        return this.content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return this.getSize() == 0?1:(int)Math.ceil((double)this.total / (double)this.getSize());
    }

    public long getTotalElements() {
        return this.total;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
