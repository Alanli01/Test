package com.alan.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alan.testproject.adapter.HistoryAdapter
import com.alan.testproject.adapter.HomeAdapter
import com.alan.testproject.bean.HomeBean
import com.alan.testproject.bean.ResponseBean
import com.alan.testproject.dao.ResponseBeanDao
import com.alan.testproject.fragment.HomeFragment
import com.alan.testproject.util.HomeBeanUtil
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    var list :ArrayList<HomeBean>? =null
    var homeAdapter: HomeAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val bean : ResponseBean = intent.getParcelableExtra("bean")
        list  = ArrayList()
        HomeBeanUtil.setData(bean,list)
        rv.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = HomeAdapter(R.layout.item_home_rv, list)
        }

    }
}