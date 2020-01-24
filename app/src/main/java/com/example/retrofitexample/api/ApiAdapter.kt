package com.example.retrofitexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiAdapter{

    const val BASE_URL = "http://jsonplaceholder.typicode.com/"

    fun makeApiAdapter(): ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

}




