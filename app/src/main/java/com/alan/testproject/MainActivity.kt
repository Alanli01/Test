package com.alan.testproject

import ExceptionHandle
import RetrofitManager
import SchedulerUtils
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.alan.testproject.ViewModel.MyViewMode
import com.alan.testproject.fragment.HistoryFragment
import com.alan.testproject.fragment.HomeFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private var mCd = CompositeDisposable()
    private val KEY ="currTabIndex"
    var handler:MyHandler? = null

    private val tags = arrayOf("home","history")
    private var mHomeFragment: HomeFragment? = null
    private var mHistoryFragment: HistoryFragment? = null
    private var currentIndex =0

    private val myViewMode: MyViewMode
        get() {
            val myViewMode = ViewModelProviders.of(this).get(MyViewMode::class.java)
            return myViewMode
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY)
        }
//        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        handler = MyHandler(WeakReference(this))
//        handler?.sendMessageDelayed(Message(),5000)

        showFragment(currentIndex)

        nvb.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 ->  currentIndex = 0
                R.id.item2 ->  currentIndex = 1
               else ->{}
            }
            showFragment(currentIndex)
            true
        }

//
//
//
//
//        myViewMode.getData().value?.let {
//            if(it.size>0) {
//                tv.text = it[it.size - 1].data
//            }
//
//        }


    }

      fun loadData() {
        mCd.add(RetrofitManager.service.data()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ bean ->
                bean.time = System.currentTimeMillis().toString()

                MyApp.instance?.daoSession?.insert(bean)

                handler?.sendMessageDelayed(Message(),5000)
                myViewMode.LoadData()

            }, { e ->
                handler?.sendMessageDelayed(Message(),5000)
                Toast.makeText(this, ExceptionHandle.handleException(e), Toast.LENGTH_LONG).show()
            })
        )
    }

      class MyHandler(val ac: WeakReference<MainActivity>?) : Handler() {

          override fun handleMessage(msg: Message) {
            val get = ac?.get()
            get?.loadData()
        }
    }
    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    fun showFragment(index:Int) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (index) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.newInstance().let {
                mHomeFragment = it
                transaction.add(R.id.rl_continer, it, tags[index])
            }
            1  //会员
            -> mHistoryFragment?.let {
                transaction.show(it)
            } ?: HistoryFragment.newInstance().let {
                mHistoryFragment = it
                transaction.add(R.id.rl_continer, it, tags[index]) }


            else -> {

            }
        }
        transaction.commitAllowingStateLoss()

    }
    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mHistoryFragment?.let { transaction.hide(it) }
    }

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
//        showToast("onSaveInstanceState->"+mIndex)
//        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if ( nvb != null) {
            outState.putInt(KEY, currentIndex)
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