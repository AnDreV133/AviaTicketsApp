package com.example.myapplication.app.master

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class MasterAdapter<T>(
    val data: MutableList<T>,
    private val res: Int
) :
    RecyclerView.Adapter<MasterAdapter.MasterViewHolder>() {
    class MasterViewHolder(val view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        return MasterViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    res,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

}