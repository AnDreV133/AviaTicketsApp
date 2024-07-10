package com.example.myapplication.app.fragments.aviatickets

import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.app.utils.BaseAdapter
import com.example.myapplication.domain.models.ItemMusicTravelModel

class MusicTravelAdapter(
    data: MutableList<ItemMusicTravelModel>
) : BaseAdapter<ItemMusicTravelModel>(data, R.layout.item_music_travel) {

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        holder.view.apply {
            findViewById<ImageView>(R.id.music_travel_image).setImageBitmap(data[position].image)
            findViewById<TextView>(R.id.music_travel_title).text = data[position].title
            findViewById<TextView>(R.id.music_travel_town).text = data[position].town
            findViewById<TextView>(R.id.music_travel_price).text = data[position].price
        }
    }
}

