package com.example.retrofitexample

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.retrofitexample.Model.Posts
import com.example.retrofitexample.api.ApiService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


import com.example.retrofitexample.api.ApiAdapter
import kotlin.coroutines.coroutineContext


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1: TextView = findViewById(R.id.tv1)
        val bt1: Button = findViewById(R.id.bt1)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted
            println("no se dieron los permisos")
        } else {
            println("si se dieron los permisos")
            bt1.setOnClickListener {

                getPosts2(tv1)
            }
        }





    }
    fun getPosts(tv1:TextView){
        /*
        var posts2:String = ""
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)

        // enqueue permite hacer una consulta asincrona
        service.getAllPosts().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if(!response.isSuccessful){ // este tipo de error podría ser un login incorrecto
                    return
                }else {
                    val posts: List<Posts>? = response?.body()
                    // println("gson: ${Gson().toJson(response?.body())}") // Gson retorna un String
                    posts2 = Gson().toJson(response?.body())
                    var data = ""
                    posts?.forEach {
                        data += "id: ${it.id}\n"
                        data += "userId: ${it.userId}\n"
                        data += "titele: ${it.title}\n"
                        data += "body: ${it.body}\n\n\n"

                    }
                    tv1.text = data
                }
            }

            override fun onFailure(call: Call<List<Posts>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
        */
    }


    fun getPosts2(tv1:TextView){
        try {
            val service = ApiAdapter.makeApiAdapter()
            val response = service.getAllPosts()
            return if (response.isSuccessful) {
                val result = response.body()
                println("result: $result")
            } else {
                println("sucedio un error al recuperar los posts, getposts2")
            }
        } catch (e: Throwable) {
            println("error en el trycatch al recuperar los posts, getposts2")
        }

    }


}
