package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.app.master.MasterAdapter
import com.example.myapplication.domen.models.PopularTownModel

class PopularTownAdapter(
    data: MutableList<PopularTownModel>
) : MasterAdapter<PopularTownModel>(
    data,
    R.id.recycler_view_sheet_dialog_town_to
) {

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        holder.view.apply {
            findViewById<ImageView>(R.id.popular_town_image).setImageBitmap(data[position].image)
            findViewById<TextView>(R.id.popular_town_title).text = data[position].title
        }
    }
}

