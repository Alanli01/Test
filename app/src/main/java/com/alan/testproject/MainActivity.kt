package com.alan.testproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import com.alan.testproject.bean.DataBean
import com.alan.testproject.dao.DataBeanDao
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private var mCd = CompositeDisposable()

    var handler:MyHandler? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        handler = MyHandler(WeakReference(this))
        handler?.sendMessageDelayed(Message(),5000)
        val dataBeanDao = MyApp.instance?.daoSession?.dataBeanDao
        val loadAll = dataBeanDao?.loadAll()
        loadAll?.let {
            if(it.size>0) {
                tv.text = it[it.size - 1].data
            }

        }

        btn.setOnClickListener {
            startActivity(Intent(this,HistoryActivity::class.java))
        }
    }

      fun loadData(dataBeanDao: DataBeanDao?) {
        mCd.add(RetrofitManager.service.data()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ bean ->
                val toString = bean.toString()
                val dataBean = DataBean()
                dataBean.time = System.currentTimeMillis().toString()
                dataBean.data = toString
                dataBeanDao?.insert(dataBean)

                tv.text = toString
                handler?.sendMessageDelayed(Message(),5000)

            }, { e ->
                handler?.sendMessageDelayed(Message(),5000)
                Toast.makeText(this, ExceptionHandle.handleException(e), Toast.LENGTH_LONG).show()
            })
        )
    }

      class MyHandler(val ac: WeakReference<MainActivity>?) : Handler() {
          val dataBeanDao = MyApp.instance?.daoSession?.dataBeanDao

          override fun handleMessage(msg: Message) {
            val get = ac?.get()
            get?.loadData(dataBeanDao)
        }
    }


    override fun onDestroy() {
        handler?.removeCallbacksAndMessages(null)
        if (!mCd.isDisposed) {
            mCd.clear()
        }
        super.onDestroy()
    }
}