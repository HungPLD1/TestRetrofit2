package com.example.kotlin_retrofit2.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.kotlin_retrofit2.connection.MyAPI
import com.example.kotlin_retrofit2.model.AndroidVersion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {
    val CODE_200 = 200
    val CODE_201 = 201
    val LOG = "Hungpld1"
    var mListAndroidVersion: ArrayList<AndroidVersion> = ArrayList()

    companion object {
        val instance = Repository()
    }

    @SuppressLint("CheckResult")
    fun handleRequestData(): ArrayList<AndroidVersion> {
        MyAPI.createService().getAndroidVersion()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result ->
                    Log.d(LOG,"Success: " + result.code().toString())
                    Log.d(LOG,result.body().toString())
                    //log request code success
                    if (result.code() == CODE_200) {
                        mListAndroidVersion.addAll(result.body()!!)
                    }
                })
            { error -> /*request thất bại*/
                Log.d(LOG,"Error: " + error.toString())
               mListAndroidVersion.add(AndroidVersion("request thất bại" ,"" ,""))
            }
        Log.d(LOG,"size: " +mListAndroidVersion.size.toString())
        return mListAndroidVersion
    }
}