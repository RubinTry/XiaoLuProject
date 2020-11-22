package cn.rubintry.xiaolu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(HeaderInterceptor())
                .build()



        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(ApiService::class.java)

        val loginService : Call<LoginResult> = service.login("rubintry" , "abc913430")
        loginService.enqueue(object : Callback<LoginResult> {
            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                if (response.body() != null) {
                    Toast.makeText(this@MainActivity, "登录成功", Toast.LENGTH_SHORT).show()
                }
                Log.d("TAG", "onResponse: ${response.toString()}")
            }

            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }

        })
    }
}