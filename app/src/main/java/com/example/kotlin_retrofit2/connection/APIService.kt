package com.example.kotlin_retrofit2.connection

import com.example.kotlin_retrofit2.model.AndroidVersion
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface APIService {

    @GET("android/jsonarray/")
    fun getAndroidVersion(): Observable<Response<ArrayList<AndroidVersion>>>

}