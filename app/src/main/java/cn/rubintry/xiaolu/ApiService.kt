package cn.rubintry.xiaolu

import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") userName: String,
              @Field("password") password: String): Call<LoginResult>
}