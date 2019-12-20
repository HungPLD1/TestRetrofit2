package com.example.kotlin_retrofit2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_retrofit2.model.AndroidVersion
import com.example.kotlin_retrofit2.repository.Repository

class MyViewModel : ViewModel() {
    private var mData = MutableLiveData<ArrayList<AndroidVersion>>()

    fun setAndroidVersion (mData : ArrayList<AndroidVersion>){
        //funtion setData
    }

    fun getAndroidVerSion () : LiveData<ArrayList<AndroidVersion>>{
        mData.value = Repository.instance.handleRequestData()
        return mData
    }
}