package com.example.retrofitexample.api

import com.example.retrofitexample.Model.Posts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService{

    @GET("posts/")
    fun getAllPosts(): Call<List<Posts>>

//    @GET("posts/{id}")
//    fun getPostById(@Path("id") id:Int):Call<Post>
//
//    @POST("post/{id}")
//    fun editPostById(@Path("id") id:Int,@Body post:Post?):Call<Post>
//    // @Body: notación para que retrofit lo reconozca como
//    // un objeto a enviar



}