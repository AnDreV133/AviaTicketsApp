package com.example.myapplication.app.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<T>(
    val data: MutableList<T>,
    private val resource: Int
) :
    RecyclerView.Adapter<BaseAdapter.MasterViewHolder>() {
    class MasterViewHolder(val view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        return MasterViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    resource,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

}