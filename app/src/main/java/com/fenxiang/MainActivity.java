package com.fenxiang;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.fenxiang.base.BaseActivity;
import com.fenxiang.fragment.MdTestFragment;
import com.fenxiang.fragment.SimpleFragment;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mainactivity_navigation)
    BottomNavigationView mainactivityNavigation;
    @BindView(R.id.mainactivity_framelayout)
    FrameLayout mainactivityFramelayout;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private MdTestFragment mdTestFragment;
    private SimpleFragment simpleFragment1;
    private SimpleFragment simpleFragment2;
    private SimpleFragment simpleFragment3;
    private SimpleFragment simpleFragment4;

    @Override
    protected void initContent() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this,0);
        initData();
        initClick();
        switchFragment(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean openToolbar() {
        return false;
    }

    @Override
    protected Activity getMyContext() {
        return this;
    }

    private void initData() {
        mdTestFragment=new MdTestFragment();
        simpleFragment1=new SimpleFragment();
        simpleFragment2=new SimpleFragment();
        simpleFragment3=new SimpleFragment();
        simpleFragment4=new SimpleFragment();
        fragments.add(mdTestFragment);
        fragments.add(simpleFragment1);
        fragments.add(simpleFragment2);
        fragments.add(simpleFragment3);
        fragments.add(simpleFragment4);
    }

    private void initClick(){
        mainactivityNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        switchFragment(0);
                        break;
                    case R.id.navigation_dashboard:
                        switchFragment(1);
                        break;
                    case R.id.navigation_notifications:
                        switchFragment(2);
                        break;
                    case R.id.navigation_zone:
                        switchFragment(3);
                        break;
                    case R.id.navigation_me:
                        switchFragment(4);
                        break;
                }

                // 默认 false【
                // false 的话 下面颜色不会变化
                return true;
            }
        });
    }

    /**
     * 根据点击的不同的按钮切换Fragment
     * @param pos
     */
    public void switchFragment(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (i == pos) {
                //说明需要显示当前的Fragment
                //判断fragment有木有被add过
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    transaction.add(R.id.mainactivity_framelayout, fragment);
                }
            } else {
                //说明这个fragment是需要隐藏的
                if (fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }
        }
        //比commit更加能够保证提交成功
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (mdTestFragment == null && fragment instanceof MdTestFragment)
            mdTestFragment = (MdTestFragment) fragment;
        if (simpleFragment1 == null && fragment instanceof SimpleFragment)
            simpleFragment1 = (SimpleFragment) fragment;
        if (simpleFragment2 == null && fragment instanceof SimpleFragment)
            simpleFragment2 = (SimpleFragment) fragment;
        if (simpleFragment3 == null && fragment instanceof SimpleFragment)
            simpleFragment3 = (SimpleFragment) fragment;
        if (simpleFragment4 == null && fragment instanceof SimpleFragment)
            simpleFragment4 = (SimpleFragment) fragment;
    }


}
