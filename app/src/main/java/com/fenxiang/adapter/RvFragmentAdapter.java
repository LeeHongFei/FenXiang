package com.fenxiang.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fenxiang.R;
import com.fenxiang.bean.HomeBean;

public class RvFragmentAdapter extends BaseQuickAdapter<HomeBean.DataBean,BaseViewHolder> {

    public RvFragmentAdapter() {
        super(R.layout.item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean item) {
        helper.setText(R.id.my_family_name,item.getName());
    }

}
