package com.fenxiang.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.fenxiang.R;
import com.fenxiang.base.BaseFragment;
import com.fenxiang.interfacediy.AppBarStateChangeListener;
import com.fenxiang.interfacediy.BannerListener;
import com.fenxiang.utils.ScreenLengthUtils;
import com.github.florent37.glidepalette.BitmapPalette;
import com.github.florent37.glidepalette.GlidePalette;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class MdTestFragment extends BaseFragment implements BannerListener {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.background_view)
    View backgroundView;
    @BindView(R.id.search_view)
    RelativeLayout searchView;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;
    @BindView(R.id.placeholder)
    ImageView placeholder;

    private List<Fragment> fragments;
    private List<String> listTitles;
    //    private RvFragment rvFragment0;
//    private SimpleFragment rvFragment1;
//    private SimpleFragment rvFragment2;
//    private SimpleFragment rvFragment3;
//    private SimpleFragment rvFragment4;
//    private SimpleFragment rvFragment5;
    private int appbarstate;
    private int viewPageState;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mdtest_layout;
    }

    @Override
    public View initViews(View view) {
        initParams();
        initData();
        initTab();
        initAppbar();
        return null;
    }

    private void initParams() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) coordinator.getLayoutParams();
        layoutParams.topMargin = ScreenLengthUtils.getStatusBarHeight(getActivity());
        coordinator.setLayoutParams(layoutParams);
    }

    private void initData() {
        fragments = new ArrayList<>();
        listTitles = new ArrayList<>();
//        rvFragment0 = new RvFragment();
//        rvFragment1 = new SimpleFragment();
//        rvFragment2 = new SimpleFragment();
//        rvFragment3 = new SimpleFragment();
//        rvFragment4 = new SimpleFragment();
//        rvFragment5 = new SimpleFragment();
//        fragments.add(rvFragment0);
//        fragments.add(rvFragment1);
//        fragments.add(rvFragment2);
//        fragments.add(rvFragment3);
//        fragments.add(rvFragment4);
//        fragments.add(rvFragment5);

        listTitles.add("推荐");
        listTitles.add("热点");
        listTitles.add("视频");
        listTitles.add("北京");
        listTitles.add("社会");
        listTitles.add("娱乐");
        listTitles.add("C罗");
        listTitles.add("梅西");
        listTitles.add("莫德里奇");

        //动态创建fragment
        for (int i = 0; i < listTitles.size(); i++) {
            if (i == 0) {
                fragments.add(new RvFragment());
            } else {
                fragments.add(new SimpleFragment());
            }
        }

        //注册监听
        for (int i = 0; i < fragments.size(); i++) {
            if (fragments.get(i) instanceof RvFragment) {
                ((RvFragment) fragments.get(i)).setBannerListener(this);
            }
        }

    }

    private void initTab() {
        for (int i = 0; i < listTitles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(listTitles.get(i)));//添加tab选项
        }

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
            }
        };
        viewpager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewpager);//将TabLayout和ViewPager关联起来。

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                viewPageState = i;
                if (i != 0) {
                    backgroundView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.titlecolor));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void initAppbar() {
        appbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {
                    //展开状态
                    appbarstate = 1;
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    appbarstate = 2;
                    backgroundView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.titlecolor));
                } else {
                    //中间状态
                    appbarstate = 3;
                }
            }
        });
    }

    @Override
    public void setAlphaOrRgb(int position, List<String> images) {
        if ((appbarstate == 1 || appbarstate == 3) && viewPageState == 0) {
            if (getActivity() != null) {
                Glide.with(getActivity()).load(images.get(position))
                        .listener(GlidePalette.with(images.get(position))
                                .use(GlidePalette.Profile.MUTED_DARK)
                                .intoBackground(backgroundView, GlidePalette.Swatch.RGB)
                                .crossfade(true, 1000))
                        .into(placeholder);
            }
        }
    }



}
