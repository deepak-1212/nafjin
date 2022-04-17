package `in`.nafj.model

data class DeviceTokenModel(
    val userId: String,
    val firebaseToken: String
)

data class DeviceTokenResponse(
    val status: Int,
    val AffectedRows: Int
)
