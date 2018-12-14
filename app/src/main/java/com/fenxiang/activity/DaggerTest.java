package com.fenxiang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fenxiang.R;
import com.fenxiang.base.BaseActivity;
import com.fenxiang.bean.DaggerBean;
import com.fenxiang.config.dagger.DaggerDaggerTestComponet;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaggerTest extends BaseActivity {

    @BindView(R.id.textview)
    TextView textview;

    @Inject
    DaggerBean daggerBean;

    @Override
    protected void initContent() {
        DaggerDaggerTestComponet.create().injet(this);
        textview.setText(daggerBean.getName());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dagger_test_layout;
    }

    @Override
    protected boolean openToolbar() {
        return false;
    }

    @Override
    protected Activity getMyContext() {
        return this;
    }

    @OnClick(R.id.textview)
    public void onClick() {
       daggerBean.shouMessage(this);
    }


}
