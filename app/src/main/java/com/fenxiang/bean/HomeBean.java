package com.fenxiang.bean;

import java.io.Serializable;
import java.util.List;

public class HomeBean implements Serializable {

    public List<DataBean> list;

    public List<DataBean> getList() {
        return list;
    }

    public void setList(List<DataBean> list) {
        this.list = list;
    }

    public static class DataBean implements Serializable{
        private String name="C罗";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
