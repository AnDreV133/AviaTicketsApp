package com.example.myapplication.app.fragments.aviatickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.domen.models.ItemMusicTravelModel
import kotlinx.coroutines.Deferred

class MusicTravelAdapter(private val items: List<ItemMusicTravelModel>) :
    RecyclerView.Adapter<MusicTravelAdapter.MusicTravelViewHolder>() {
    class MusicTravelViewHolder(val view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicTravelViewHolder {
        return MusicTravelViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_music_travel,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MusicTravelViewHolder, position: Int) {
        holder.view.apply {
            findViewById<ImageView>(R.id.music_travel_image).setImageBitmap(items[position].image)
            findViewById<TextView>(R.id.music_travel_title).text = items[position].title
            findViewById<TextView>(R.id.music_travel_town).text = items[position].town
            findViewById<TextView>(R.id.music_travel_price).text = items[position].price
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

