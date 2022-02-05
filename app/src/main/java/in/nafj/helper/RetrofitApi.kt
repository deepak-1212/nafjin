package `in`.nafj.helper

import `in`.nafj.model.StoreOtpModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitApi {

    @POST("store_otp.php")
    fun storeOtp(@Body storeOtpModel: StoreOtpModel): Call<JsonObject>

    @GET("submitsms.jsp")
    fun sendSms(
        @Query("user") user: String?,
        @Query("key") key: String?,
        @Query("mobile") mobile: String?,
        @Query("message") message: String?,
        @Query("senderid") senderid: String?,
        @Query("accusage") accusage: String?,
        @Query("entityid") entityid: String?,
        @Query("tempid") tempid: String?
    ): Call<String?>

}
