package com.example.myapplication.app.fragments.aviatickets

import androidx.lifecycle.ViewModel
import com.example.myapplication.domen.models.ItemMusicTravelModel

class AviaTicketsFragmentModel (
    val townFrom: String = "",
    val townTo: String = "",
    val items: List<ItemMusicTravelModel> = emptyList()
)

class AviaTicketsViewModel : ViewModel() {


    private fun String.addSpaceToPrice() = buildString {
        var counterInterval = 0
        for (c in this@addSpaceToPrice.reversed()) {
            if (counterInterval == 3) {
                append(' ')
                counterInterval = 0
            }

            append(c)
            counterInterval++
        }
        reverse()
    }
}