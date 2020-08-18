package com.alan.testproject

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

class MainActivity : AppCompatActivity() {
    private var mCd = CompositeDisposable()

    val handler by lazy {
        MyHandler()
    }
    

    private val dataBeanDao: DataBeanDao?
        get() {
            val dataBeanDao = MyApp.instance?.daoSession?.dataBeanDao
            return dataBeanDao
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

        handler.sendMessageDelayed(Message(),5000)

        val loadAll = dataBeanDao?.loadAll()
        loadAll?.let {
            if(it.size>0) {
                tv.text = it[it.size - 1].data
            }

        }

        btn.setOnClickListener {

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
                handler.sendMessageDelayed(Message(),5000)

            }, { e ->
                Toast.makeText(this, ExceptionHandle.handleException(e), Toast.LENGTH_LONG).show()
            })
        )
    }

    inner class  MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            loadData(dataBeanDao)
        }
    }
    inner class MyRunnable:Runnable{
        override fun run() {
            loadData(dataBeanDao)

        }

    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        if (!mCd.isDisposed) {
            mCd.clear()
        }
        super.onDestroy()
    }
}