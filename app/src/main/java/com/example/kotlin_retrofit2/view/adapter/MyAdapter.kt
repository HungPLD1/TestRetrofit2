package com.example.kotlin_retrofit2.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_retrofit2.R
import com.example.kotlin_retrofit2.model.AndroidVersion

class MyAdapter( var mContext : Context , var mListData : ArrayList<AndroidVersion> , var clicklistener: OnItemClicklistener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        var mView : View? = null
        mView = LayoutInflater.from(mContext).inflate(R.layout.raw_layout,parent,false)

        return MyViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mListData.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.txtName!!.text = mListData.get(position).name
        holder.txtVersion!!.text = mListData.get(position).version
        holder.txtApiLever!!.text = mListData.get(position).api

        holder.lnAndroidVersion!!.setOnClickListener {
            clicklistener.onItemClick(position)
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName : TextView? = null
        var txtVersion : TextView? = null
        var txtApiLever : TextView? =null
        var lnAndroidVersion : LinearLayout? = null

        init {
            txtName = itemView.findViewById(R.id.tvName)
            txtVersion = itemView.findViewById(R.id.tvVersion)
            txtApiLever = itemView.findViewById(R.id.tvApiLevel)
            lnAndroidVersion = itemView.findViewById(R.id.rawAndroidversion)
        }
    }
}