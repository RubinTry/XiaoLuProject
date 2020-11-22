package cn.rubintry.xiaolu

data class LoginResult(
    val createdAt: String,
    val emailVerified: Boolean,
    val mobilePhoneVerified: Boolean,
    val objectId: String,
    val sessionToken: String,
    val updatedAt: String,
    val username: String
)