package `in`.nafj.helper

import `in`.nafj.helper.Constants.Companion.domainUrl
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {


    companion object {
        var url: String = Constants.url
        val SMS_BASE_URL = "http://netsms.netcomindia.net/"

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
            retrofit = Retrofit.Builder().client(okhttpClient()).baseUrl(domainUrl)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
            return retrofit
        }

        fun getClientSms(): Retrofit? {
            retrofit =
                Retrofit.Builder().baseUrl(SMS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
            return retrofit
        }

    }

}