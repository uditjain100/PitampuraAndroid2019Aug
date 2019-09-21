package com.codingblocks.networkingokhttp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okHttpClient = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.github.com/users/aggarwalpulkit596")
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("NETWORK", e.localizedMessage.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("NETWORK", response.body?.string())
                val body = response.body?.string()
                val jsonData = JSONObject(body)
                val user = User(
                    avatar_url = jsonData.getString("avatar_url"),
                    id = jsonData.getInt("id"),
                    type = jsonData.getString("type"),
                    login = jsonData.getString("login")
                )


            }

        })
    }
}