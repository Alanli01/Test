package com.alan.testproject.adapter

import com.alan.testproject.R
import com.alan.testproject.bean.ResponseBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HistoryAdapter(layoutResId: Int, data: List<ResponseBean?>?) :
    BaseQuickAdapter<ResponseBean, BaseViewHolder>(layoutResId, data as MutableList<ResponseBean>?) {
    override fun convert(
        baseViewHolder: BaseViewHolder,
        bean: ResponseBean
    ) {
        baseViewHolder.setText(R.id.tv_time, bean.time)
        baseViewHolder.setText(R.id.tv_data, bean.authorizations_url)
    }
}