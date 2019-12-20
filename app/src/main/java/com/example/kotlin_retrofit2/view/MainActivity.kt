package com.example.kotlin_retrofit2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_retrofit2.R
import com.example.kotlin_retrofit2.model.AndroidVersion
import com.example.kotlin_retrofit2.view.adapter.MyAdapter
import com.example.kotlin_retrofit2.view.adapter.OnItemClicklistener
import com.example.kotlin_retrofit2.viewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(),OnItemClicklistener {
    private var mListAndroidVersion : ArrayList<AndroidVersion> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this)[MyViewModel::class.java]

        mListAndroidVersion = model.getAndroidVerSion().value as ArrayList<AndroidVersion>

        rcvAndroidVersion.layoutManager = LinearLayoutManager(this)
        rcvAndroidVersion.adapter = MyAdapter(this,mListAndroidVersion,this)
    }

    override fun onItemClick(positon: Int) {
        Toast.makeText(this, mListAndroidVersion.get(positon).toString(),Toast.LENGTH_SHORT).show()
    }
}
