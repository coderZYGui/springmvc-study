package com.sunny.vo;


import java.util.ArrayList;
import java.util.List;

public class FormBean {
    private List<Long> ids = new ArrayList<Long>();

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }
}
