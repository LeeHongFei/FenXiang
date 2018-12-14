package com.fenxiang.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fenxiang.R;
import com.fenxiang.base.BaseFragment;

import javax.xml.parsers.FactoryConfigurationError;

import butterknife.BindView;

public class SimpleFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_simple_layout;
    }

    @Override
    public View initViews(View view) {
        return null;
    }

}
