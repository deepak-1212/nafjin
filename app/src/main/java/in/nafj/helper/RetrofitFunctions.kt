package `in`.nafj.helper

import `in`.nafj.activity.LoginOtpActivity
import `in`.nafj.model.StoreOtpModel
import android.util.Log
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.util.*

private const val TAG = "RetrofitFunctions"

class RetrofitFunctions {
    companion object {
        fun sendOtp(passedNumber: String, sendOtpInterface: LoginOtpActivity.SendOtpInterface,
                    appName: String) {
            val finalResRandom = DecimalFormat("000000").format(Random().nextInt(999999).toLong())
            println(finalResRandom)

            val message =
                "Your OTP for $appName is $finalResRandom for Login. Do not share this with anyone."

            val retrofit = RetrofitClient.getClientSms()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<String?> = retrofitApi.sendSms(
                "right2cart", "4de57e62ebXX",
                "+91$passedNumber", message, "DALERT", "1", "DLT Number", "DLT Template ID"
            )

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<String?> {
                override fun onResponse(call: Call<String?>, response: Response<String?>) {
                    Log.d(TAG, "onResponse: " + response.body())
                    val result = response.body()
                    if (result!!.contains("sent")) {
                        sendOtpInterface.onOtpSent(finalResRandom)
                    }
                }

                override fun onFailure(call: Call<String?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    sendOtpInterface.onOtpSendingFailed()

                }
            })
        }

        fun createRecordInServer(
            passedNumber: String,
            createRowInServerInterface: LoginOtpActivity.CreateRowInServerInterface,
            finalResRandom: String
        ) {
            val retrofit = RetrofitClient.getClientSms()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<JsonObject> = retrofitApi.storeOtp(StoreOtpModel(passedNumber, finalResRandom))

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<JsonObject?> {
                override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                    Log.d(TAG, "onResponse: " + response.body())

                    if (response.code() == 200) {
                        val result = response.body()
                        createRowInServerInterface.onRowCreated()
                    }
                    createRowInServerInterface.onRowCreationFailed()

                }

                override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    createRowInServerInterface.onRowCreationFailed()

                }
            })
        }
    }
}