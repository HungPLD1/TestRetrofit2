package com.example.kotlin_retrofit2.connection

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object MyAPI {
    val BASE_URL = "https://api.learn2crack.com/"
    private var retrofit : Retrofit? = null
    fun createService (): APIService{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        if (retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
        return retrofit!!.create(APIService::class.java)
    }
}