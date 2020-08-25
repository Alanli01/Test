package com.alan.testproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alan.testproject.MyApp
import com.alan.testproject.bean.ResponseBean

class MyViewMode : ViewModel() {
    private val datas: MutableLiveData<List<ResponseBean>?> = MutableLiveData()

    val dataBeanDao = MyApp.instance?.daoSession?.responseBeanDao

    fun  getData() : LiveData<List<ResponseBean>?> {
        LoadData()
        return datas
    }

     fun LoadData() {
        val loadAll = dataBeanDao?.loadAll()
        datas.value = loadAll
    }
}