package com.alan.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alan.testproject.adapter.HistoryAdapter
import com.alan.testproject.dao.DataBeanDao
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
      val dataBeanDao: DataBeanDao? = MyApp.instance?.daoSession?.dataBeanDao
        val loadAll = dataBeanDao?.loadAll()
        loadAll?.let {
            if(it.size>0) {
                rv.apply {
                    layoutManager = LinearLayoutManager(this@HistoryActivity)
                    adapter= HistoryAdapter(R.layout.item_rv,it)
                }
            }

        }
    }
}