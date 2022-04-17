package `in`.nafj.model

import `in`.nafj.helper.SingleProductResponse

data class ViewProductModel(
    val categoryName: String,
    val productList: SingleProductResponse
)
