package com.fenxiang.config.dagger;

import com.fenxiang.activity.DaggerTest;

import dagger.Component;

@Component
public interface DaggerTestComponet {
    void injet(DaggerTest daggerTest);
}
