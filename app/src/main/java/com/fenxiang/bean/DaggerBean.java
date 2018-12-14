package com.fenxiang.bean;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

public class DaggerBean {

    @Inject
    public DaggerBean() {
    }

    public String name="C罗";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shouMessage(Context context){
        Toast.makeText(context,"我是C罗",Toast.LENGTH_SHORT).show();
    }

}
