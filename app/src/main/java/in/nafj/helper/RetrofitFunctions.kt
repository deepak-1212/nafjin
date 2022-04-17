package `in`.nafj.helper

import `in`.nafj.activity.HomeActivity
import `in`.nafj.activity.LoginOtpActivity
import `in`.nafj.activity.LoginWithPasswordInterface
import `in`.nafj.model.LoginWithPasswordModel
import `in`.nafj.model.StoreOtpModel
import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.util.*

private const val TAG = "RetrofitFunctions"

class RetrofitFunctions {
    companion object {
        fun sendOtp(
            passedNumber: String,
            sendOtpInterface: LoginOtpActivity.SendOtpInterface,
            appName: String,
            firebaseToken: String
        ) {
            val finalResRandom = DecimalFormat("000000").format(Random().nextInt(999999).toLong())
            println(finalResRandom)

            val message =
                "Your OTP for $appName is $finalResRandom for Login. Do not share this with anyone."

            val retrofit = RetrofitClient.getClientSms()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<ResponseBody> = retrofitApi.sendSms(
                "nafj2022", "0a82df3400XX",
                "+91$passedNumber", message, "INFOSM", "1", "DLT Number", "DLT Template ID"
            )

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    Log.d(TAG, "onResponse: " + response.body())
                    val result = response.body()!!.string()
                    if (result.contains("sent")) {
                        sendOtpInterface.onOtpSent(finalResRandom, firebaseToken)
                    } else
                        sendOtpInterface.onOtpSendingFailed()

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    sendOtpInterface.onOtpSendingFailed()

                }
            })
        }


        fun createRecordInServer(
            passedNumber: String,
            createRowInServerInterface: LoginOtpActivity.CreateRowInServerInterface,
            finalResRandom: String,
            firebaseToken: String
        ) {
            val retrofit = RetrofitClient.getClient()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<CreateRecordInServerResponse> =
                retrofitApi.loginRegister(
                    StoreOtpModel(
                        passedNumber,
                        finalResRandom,
                        firebaseToken
                    )
                )

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<CreateRecordInServerResponse?> {
                override fun onResponse(
                    call: Call<CreateRecordInServerResponse?>,
                    response: Response<CreateRecordInServerResponse?>
                ) {

                    if (response.code() == 200) {
                        val createRecordInServerResponse = response.body()!!
                        if (createRecordInServerResponse.AffectedRows == 1)
                            createRowInServerInterface.onRowCreated()
                        else
                            createRowInServerInterface.onRowCreationFailed()
                    }
                    createRowInServerInterface.onRowCreationFailed()

                }

                override fun onFailure(call: Call<CreateRecordInServerResponse?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    createRowInServerInterface.onRowCreationFailed()

                }
            })
        }

        fun loginWithPassword(
            passedNumber: String,
            passedPassword: String,
            loginWithPasswordInterface: LoginWithPasswordInterface,
            firebaseToken: String
        ) {
            val retrofit = RetrofitClient.getClient()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<CreateRecordInServerResponse> =
                retrofitApi.loginWithPassword(
                    LoginWithPasswordModel(
                        passedNumber,
                        passedPassword,
                        firebaseToken
                    )
                )

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<CreateRecordInServerResponse?> {
                override fun onResponse(
                    call: Call<CreateRecordInServerResponse?>,
                    response: Response<CreateRecordInServerResponse?>
                ) {
                    if (response.code() == 200) {
                        val createRecordInServerResponse = response.body()!!
                        if (createRecordInServerResponse.AffectedRows == 1)
                            loginWithPasswordInterface.onLoginSuccess(passedNumber)
                        else
                            loginWithPasswordInterface.onLoginFailure("Incorrect details")
                    } else {
                        loginWithPasswordInterface.onLoginFailure("Internet issue")
                    }

                }

                override fun onFailure(call: Call<CreateRecordInServerResponse?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    loginWithPasswordInterface.onLoginFailure(t.message!!)

                }
            })
        }

        fun verifyOtp(
            passedNumber: String,
            verifyOtpInterface: LoginOtpActivity.VerifyOtpInterface,
            otpEntered: String
        ) {
            val retrofit = RetrofitClient.getClient()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<VerifyOtpResponse> =
                retrofitApi.verifyOtp(StoreOtpModel(passedNumber, otpEntered))

            Log.d(TAG, "onClick: " + call.request().url())

            call.enqueue(object : Callback<VerifyOtpResponse?> {
                override fun onResponse(
                    call: Call<VerifyOtpResponse?>,
                    response: Response<VerifyOtpResponse?>
                ) {
                    if (response.code() == 200) {
                        val verifyOtpResponse = response.body()!!
                        if (verifyOtpResponse.Otp.equals("Matched", true))
                            verifyOtpInterface.onOtpVerified()
                        else
                            verifyOtpInterface.onOtpVerificationFailed()
                    }
                }

                override fun onFailure(call: Call<VerifyOtpResponse?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    verifyOtpInterface.onOtpVerificationFailed()

                }
            })
        }

        fun categoryListing(categoryListingInterface: HomeActivity.CategoryListingInterface) {
            val retrofit = RetrofitClient.getClient()!!
            val retrofitApi = retrofit.create(RetrofitApi::class.java)
            val call: Call<ListingResponse> = retrofitApi.categoryListing()

            call.enqueue(object : Callback<ListingResponse?> {
                override fun onResponse(
                    call: Call<ListingResponse?>,
                    response: Response<ListingResponse?>
                ) {
                    if (response.code() == 200) {
                        val listingResponse = response.body()!!
                        categoryListingInterface.onListingSuccess(listingResponse)
                    }
                    categoryListingInterface.onListingFailure()
                }

                override fun onFailure(call: Call<ListingResponse?>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message)
                    categoryListingInterface.onListingFailure()

                }
            })
        }
    }
}