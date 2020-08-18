package com.alan.testproject.adapter

import com.alan.testproject.R
import com.alan.testproject.bean.DataBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class HistoryAdapter(layoutResId: Int, data: List<DataBean?>?) :
    BaseQuickAdapter<DataBean, BaseViewHolder>(layoutResId, data as MutableList<DataBean>?) {
    override fun convert(
        baseViewHolder: BaseViewHolder,
        dataBean: DataBean
    ) {
        baseViewHolder.setText(R.id.tv_time, dataBean.time)
        baseViewHolder.setText(R.id.tv_data, dataBean.data)
    }
}