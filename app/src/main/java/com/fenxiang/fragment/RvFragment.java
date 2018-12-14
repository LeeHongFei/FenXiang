package com.fenxiang.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fenxiang.R;
import com.fenxiang.activity.DaggerTest;
import com.fenxiang.adapter.RvFragmentAdapter;
import com.fenxiang.base.BaseFragment;
import com.fenxiang.bean.BanKuaiLunBo;
import com.fenxiang.bean.HomeBean;
import com.fenxiang.config.Constant;
import com.fenxiang.config.MyImageLoader;
import com.fenxiang.config.retrofit.Network;
import com.fenxiang.interfacediy.BannerListener;
import com.fenxiang.utils.LogUtils;
import com.youth.banner.Banner;
import com.youth.banner.view.BannerViewPager;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RvFragment extends BaseFragment {

    @BindView(R.id.fragment_rv_rv)
    RecyclerView fragmentRvRv;

    private List<HomeBean.DataBean> list;
    private RvFragmentAdapter rvFragmentAdapter;
    private View bannerhead;
    private Banner banner;
    private FrameLayout bannerfl;
    private ImageView banneriv;
    private List<String> images;
    private BannerListener bannerListener;

    public void setBannerListener(BannerListener bannerListener) {
        this.bannerListener = bannerListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rv_layout;
    }

    @Override
    public View initViews(View view) {
        initDate();
        initRv();
        initBanner();
        initRvClick();
        return null;
    }

    @Override
    protected void loadData(boolean isVisible) {
        super.loadData(isVisible);
        if (isVisible) {
            getLunBo();
        }
    }

    private void initDate() {
        list = new ArrayList<>();
        images = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new HomeBean.DataBean());
        }

        images.add(Constant.picurl1);
        images.add(Constant.picurl2);
        images.add(Constant.picurl3);
        images.add(Constant.picurl4);
    }

    private void initRv() {
        bannerhead = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_banner_head, null);
        bannerfl = bannerhead.findViewById(R.id.banner_fl);
        banneriv = bannerhead.findViewById(R.id.banner_iv_test);
        banner = bannerhead.findViewById(R.id.banner);
        rvFragmentAdapter = new RvFragmentAdapter();
        fragmentRvRv.setHasFixedSize(true);
        fragmentRvRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentRvRv.setAdapter(rvFragmentAdapter);
        rvFragmentAdapter.setNewData(list);
        rvFragmentAdapter.addHeaderView(bannerhead);
    }

    private void initRvClick() {
        rvFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), DaggerTest.class));
            }
        });
    }

    private void initBanner() {
        //设置图片加载器
        banner.setImageLoader(new MyImageLoader(bannerfl));
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                if (bannerListener != null) {
                    bannerListener.setAlphaOrRgb(i, images);
                }
            }

            @SuppressLint("LongLogTag")
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        init();
    }

    private void init() {
        try {
            Class<?> bannerClass = banner.getClass();
            Field bannerviewpagerfield = null;
            try {
                bannerviewpagerfield = bannerClass.getDeclaredField("viewPager");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            bannerviewpagerfield.setAccessible(true);
            BannerViewPager bannerViewPager = null;
            try {
                bannerViewPager = (BannerViewPager) bannerviewpagerfield.get(banner);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            bannerviewpagerfield.setAccessible(false);
            if (bannerViewPager != null) {
                bannerViewPager.setPageMargin(40);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bannerViewPager.getLayoutParams();
                layoutParams.leftMargin = 30;
                layoutParams.rightMargin = 30;
                bannerViewPager.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            LogUtils.e("反射viewpager", e.toString());
        }
    }

    private void getLunBo() {
        JSONObject root = new JSONObject();
        try {
            root.put("section_id", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtils.e("啦啦啦啦啦啦",root.toString());
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),root.toString());

        Subscription subscribe = Network.RequestJava()
                .getLunBo(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BanKuaiLunBo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                              LogUtils.e("啦啦啦啦啦啦",e);
                    }

                    @Override
                    public void onNext(BanKuaiLunBo banKuaiLunBo) {
                       if (banKuaiLunBo!=null){
                           LogUtils.e("啦啦啦啦啦啦",banKuaiLunBo.getResult_message());
                       }
                    }
                });


    }


}
