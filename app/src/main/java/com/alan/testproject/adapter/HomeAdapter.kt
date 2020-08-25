package com.alan.testproject.adapter

import com.alan.testproject.R
import com.alan.testproject.bean.HomeBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HomeAdapter(layoutResId: Int, data: List<HomeBean?>?) :
    BaseQuickAdapter<HomeBean, BaseViewHolder>(layoutResId, data as MutableList<HomeBean>?) {
    override fun convert(
        baseViewHolder: BaseViewHolder,
        homeBean: HomeBean
    ) {
        baseViewHolder.setText(R.id.tv_name, homeBean.name)
        baseViewHolder.setText(R.id.tv_url, homeBean.url)
    }
}