package com.alan.testproject

import android.app.Application
import com.alan.testproject.dao.DaoMaster
import com.alan.testproject.dao.DaoMaster.DevOpenHelper
import com.alan.testproject.dao.DaoSession

class MyApp : Application() {
    var daoSession: DaoSession? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDao()
    }

    private fun initDao() {
        val helper = DevOpenHelper(this, "MyTestapp.db")
        val db = helper.writableDatabase
        val daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
    }

    companion object {
        /**
         * 返回 application对象
         */
        var instance: MyApp? = null
            private set

    }
}