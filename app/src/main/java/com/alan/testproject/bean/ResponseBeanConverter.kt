package com.alan.testproject.bean

import com.alan.testproject.bean.ResponseBean
import com.google.gson.Gson
import org.greenrobot.greendao.converter.PropertyConverter

class ResponseBeanConverter : PropertyConverter<ResponseBean, String?> {
    override fun convertToEntityProperty(databaseValue: String?): ResponseBean {
        return Gson().fromJson(databaseValue, ResponseBean::class.java)
    }

    override fun convertToDatabaseValue(entityProperty: ResponseBean): String? {
        return Gson().toJson(entityProperty)
    }
}