package `in`.nafj.model

import com.google.gson.annotations.SerializedName

class ProfileDetails {

    data class UpdateProfileDetailModel(
        @SerializedName("name")
        val name: String,
        @SerializedName("number")
        val number: String,
        @SerializedName("email")
        val email: String
    )
}