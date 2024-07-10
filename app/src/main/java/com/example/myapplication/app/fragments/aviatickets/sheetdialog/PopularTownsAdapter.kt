package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.app.utils.BaseAdapter
import com.example.myapplication.domain.models.PopularTownModel

class PopularTownsAdapter(
    data: MutableList<PopularTownModel>
) : BaseAdapter<PopularTownModel>(
    data,
    R.id.sheet_dialog_recycler_view_popular_towns
) {

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        holder.view.apply {
            findViewById<ImageView>(R.id.popular_town_image).setImageBitmap(data[position].image)
            findViewById<TextView>(R.id.popular_town_title).text = data[position].title
        }
    }
}

