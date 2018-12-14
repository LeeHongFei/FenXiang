package com.fenxiang.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fenxiang.R;
import com.fenxiang.config.eventbus.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder butterKinfeBind;
    private LinearLayout parentLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(R.layout.activity_base_layout);
        setContentView(getLayoutId());
        init();
        setBackIcon();
        initContent();
    }

    private void init() {
        butterKinfeBind = ButterKnife.bind(this);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            //有注解的activity就注册
            EventBus.getDefault().register(getMyContext());
        }
        openToolbar(openToolbar());
    }

    protected abstract int getLayoutId();
    protected abstract boolean openToolbar();
    protected abstract void initContent();
    protected abstract Activity getMyContext();

    //把子类的布局传进来  自己写一个viewgroup 再创建线性布局
    private void initContentView(@LayoutRes int layoutResID) {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new LinearLayout(this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        viewGroup.addView(parentLinearLayout);
        //  add the layout of BaseActivity in parentLinearLayout
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    /**
     * @param layoutResID the layout id of sub Activity
     * 重写这个方法 就是让这个线性布局成为一个载体  子类的布局自然就在toolbar下面
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //  added the sub-activity layout id in parentLinearLayout
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    //返回键
    private void setBackIcon() {
        if (null != toolbar && isShowBacking()) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
            }
            //这种是自定义一个返回键的图标
//            toolbar.setNavigationIcon(R.mipmap.btn_back_black);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onBackPressed();
//                }
//            });
        }
    }

    /**
     * 设置toolbar中间标题
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
    }

    /**
     * 设置toolbar右边文字
     * @param title
     */
    public void setToolbarRightTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(title);
        } else {
            tvRight.setVisibility(View.GONE);
        }
    }

    /**
     * 设置右边文字点击事件
     */
    public void setRightOnclick(View.OnClickListener click) {
        tvRight.setOnClickListener(click);
    }

    /**
     * @param off true隐藏toolbar  标题栏自己在布局设置
     * 设置不显示toolbar
     */
    public void openToolbar(boolean off) {
        if (!off) {
            toolbar.setVisibility(View.GONE);
        }
    }

    //设置toolbar的背景颜色
    public void setToobarBcColor(@ColorInt int color) {
        toolbar.setBackgroundColor(color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    /**
     * 设置继承baseactivity的activity是否显示返回键操作
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (butterKinfeBind != null) {
            butterKinfeBind.unbind();
        }
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            //有注解的activity就注册
            EventBus.getDefault().unregister(getMyContext());
        }
    }



}
