package com.kintree.helper

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {


    companion object {
        var url: String = Constants.url

        var retrofit: Retrofit? = null
        var gson = GsonBuilder()
            .setLenient()
            .create()

        private fun okhttpClient(): OkHttpClient {

            return OkHttpClient().newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        }

        fun getClient(): Retrofit? {
            retrofit = Retrofit.Builder().client(okhttpClient()).baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
            return retrofit
        }

    }

}