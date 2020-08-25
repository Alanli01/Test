package com.alan.testproject

import com.alan.testproject.bean.HomeBean
import com.alan.testproject.bean.ResponseBean
import com.alan.testproject.util.HomeBeanUtil
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HomeBeanUtilTest {
    var responseBean :ResponseBean? =null
    var datas :ArrayList<HomeBean>? =null
    @Before
    fun  initMocks() {
        responseBean = ResponseBean()
        datas = ArrayList()
        responseBean?.user_organizations_url ="sdksjdk"
        responseBean?.commit_search_url ="fdgdfdfd"
        HomeBeanUtil.setData(responseBean,datas)
    }
    @Test
    fun setData_success_get_params_null() {
        Assert.assertTrue(datas?.get(5)?.url==null)
    }
    @Test
    fun setData_success_get_params_equ() {
        Assert.assertTrue(datas?.get(2)?.url.equals("fdgdfdfd"))
    }
    @Test
    fun setData_success_size_() {
        Assert.assertTrue(datas?.size!! >0)
    }
    @Test
    fun setData_success_total_siz() {
        Assert.assertTrue(datas?.size ==30)
    }

}