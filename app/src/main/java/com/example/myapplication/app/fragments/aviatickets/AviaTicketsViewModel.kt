package com.example.myapplication.app.fragments.aviatickets

import androidx.lifecycle.ViewModel
import com.example.myapplication.domen.models.ItemMusicTravelModel

class AviaTicketsFragmentModel (
    val townFrom: String = "",
    val townTo: String = "",
    val items: List<ItemMusicTravelModel> = emptyList()
)

class AviaTicketsViewModel : ViewModel() {

}