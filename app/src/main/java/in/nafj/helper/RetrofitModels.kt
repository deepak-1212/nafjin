package `in`.nafj.helper

import com.google.gson.annotations.SerializedName

data class CreateRecordInServerResponse(
    @SerializedName("AffectedRows")
    val AffectedRows: Int,
    @SerializedName("Contact")
    val Contact: Long,
    @SerializedName("Operation")
    val Operation: String
)

data class VerifyOtpResponse(
    @SerializedName("Otp")
    val Otp: String,
    @SerializedName("Contact")
    val Contact: Long
)

data class ListingResponse(
    @SerializedName("CategoryDetails")
    val categoryDetails: ArrayList<SingleCategoryResponse>
)

data class SingleCategoryResponse(
    @SerializedName("CategoryId")
    val categoryId: String,
    @SerializedName("CategoryName")
    val categoryName: String,
    @SerializedName("CategoryProducts")
    val categoryProducts: ArrayList<SingleProductResponse>
)

data class SingleProductResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("productDetails")
    val productDetails: SingleProductDetail
)

data class SingleProductDetail(val _sku: String, val _price: Int, val _stock: Int)

class RetrofitModels {

}