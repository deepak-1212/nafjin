package `in`.nafj.helper

import `in`.nafj.model.DeviceTokenModel
import `in`.nafj.model.DeviceTokenResponse
import `in`.nafj.model.LoginWithPasswordModel
import `in`.nafj.model.StoreOtpModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitApi {

    @POST("login_register.php")
    fun loginRegister(@Body storeOtpModel: StoreOtpModel): Call<CreateRecordInServerResponse>

    @POST("login_with_password.php")
    fun loginWithPassword(@Body loginWithPasswordModel: LoginWithPasswordModel): Call<CreateRecordInServerResponse>


    @POST("verifyOtp.php")
    fun verifyOtp(@Body storeOtpModel: StoreOtpModel): Call<VerifyOtpResponse>

    @POST("listing.php")
    fun categoryListing(): Call<ListingResponse>

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
    ): Call<ResponseBody>

    @POST("deviceToken.php")
    fun deviceToken(
        @Body deviceTokenModel: DeviceTokenModel
    ): Call<DeviceTokenResponse>

}
