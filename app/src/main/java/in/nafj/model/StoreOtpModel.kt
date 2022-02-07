package `in`.nafj.model

import com.google.gson.annotations.SerializedName

data class StoreOtpModel(
    @SerializedName("LoginNumber")
    val number: String,
    @SerializedName("LoginOtp")
    val otp: String,
    @SerializedName("LoginToken")
    val firebaseToken: String = ""
)
