
import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.MultipartBody
import org.json.JSONObject
import retrofit2.http.*

/**
 *
 * Api 接口
 */


interface ApiService {

    @JvmSuppressWildcards
    @GET("/")
    fun data(): Observable<Any>

}