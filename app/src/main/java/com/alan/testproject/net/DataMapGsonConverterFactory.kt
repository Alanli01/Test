package com.ina.ikd.spp.net

import ApiException
import BaseResponse
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

/**
 * 文件描述：
 * 作者：Alan
 * 创建时间：2019/11/13
 * 更改时间：2019/11/13
 */
class DataMapGsonConverterFactory  constructor(private val gson: Gson): Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        var rawType = getRawType(type)
        if(rawType is BaseResponse<*>) {
            return super.responseBodyConverter(type, annotations, retrofit)
        }else{
            val adapter = gson.getAdapter(TypeToken.get(type))
            return DataMapGsonResponseBodyConverter(
                adapter
            )
        }
    }


    private class DataMapGsonResponseBodyConverter<T> internal constructor(
        private val adapter: TypeAdapter<T>
    ) : Converter<ResponseBody, T> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T {
            try {
                var json = value.string()

                    return adapter.fromJson(json)

            } catch (e: JSONException) {
                throw IOException(e)
            } finally {
                value.close()
            }
        }
    }

}