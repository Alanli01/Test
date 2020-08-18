
import com.google.gson.JsonParseException

import org.json.JSONException

import java.net.ConnectException

import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 * 12/5.
 * desc: 异常处理类
 */

class ExceptionHandle {


    companion object {
         var errorCode :String = ErrorStatus.UNKNOWN_ERROR
         var errorMsg :String= "Request failed, please try again later"

        fun handleException(e: Throwable): String {
            e.printStackTrace()
            if (e is SocketTimeoutException) {//网络超时
                errorMsg = "Network connection abnormal"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is ConnectException) { //均视为网络错误
                errorMsg = "Network connection abnormal"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is JsonParseException
                    || e is JSONException
                    || e is ParseException) {   //均视为解析错误
                errorMsg = "Data parsing exception"
                errorCode = ErrorStatus.SERVER_ERROR
            } else if (e is ApiException) {//服务器返回的错误信息
                errorMsg = e.msg
                errorCode = e.code
            } else if (e is UnknownHostException) {
                errorMsg = "Network connection abnormal"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is IllegalArgumentException) {
                errorMsg = "Parameter error"
                errorCode = ErrorStatus.SERVER_ERROR
            } else {//未知错误
                try {
                } catch (e1: Exception) {
                }

                errorMsg = "unknown mistake"
                errorCode = ErrorStatus.UNKNOWN_ERROR
            }
            return errorMsg
        }

    }


}
