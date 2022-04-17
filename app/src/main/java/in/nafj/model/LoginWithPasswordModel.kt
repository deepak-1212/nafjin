package `in`.nafj.model

import com.google.gson.annotations.SerializedName

data class LoginWithPasswordModel(
    @SerializedName("LoginNumber")
    val number: String,
    @SerializedName("LoginPassword")
    val password: String,
    @SerializedName("LoginToken")
    val firebaseToken: String = ""
)
