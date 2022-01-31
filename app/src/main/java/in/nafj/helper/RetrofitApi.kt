package com.kintree.helper

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitApi {

    @POST("sendOtp")
    fun sendOtp(@Body jsonObject: JsonObject): Call<JsonObject>

}
