package com.fenxiang.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fenxiang.config.eventbus.BindEventBus;
import com.fenxiang.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    //当前Fragment是否处于可见状态标志，防止因ViewPager的缓存机制而导致回调函数的触发
    private boolean isFragmentVisible;
    //是否是第一次开启网络加载
    public boolean isFirst;

    private View view;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null)
        view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews(view);
        //可见，但是并没有加载过
        if (isFragmentVisible && !isFirst) {
            loadData(true);
        }
        LogUtils.e("onCreateView");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.e("onStart");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.e("onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.e("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.e("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.e("onStop");
    }

    public abstract int getLayoutId();

    public abstract View initViews(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isFragmentVisible = true;
        }
        if (view == null) {
            return;
        }
        //可见，并且没有加载过
        if (!isFirst&&isFragmentVisible) {
            loadData(true);
            return;
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisible) {
            loadData(false);
            isFragmentVisible = false;
        }
    }

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void loadData(boolean isVisible) {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
        LogUtils.e("onCreate");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null) {
            unbinder.unbind();
        }
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
        LogUtils.e("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("onDestroy");

        //销毁时，取消网络请求
//        OkGo.getInstance().cancelTag(this);
    }

}
