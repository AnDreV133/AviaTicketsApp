package com.example.myapplication.app.fragments.aviatickets

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.fragments.FragmentFactory
import com.example.myapplication.domen.models.ItemMusicTravelModel
import com.example.myapplication.domen.usecases.GetMusicTravelsUseCase
import com.example.myapplication.repositories.MusicTravelRepositoryImpl
import kotlinx.coroutines.launch


class AviaTicketsFragment :
    FragmentFactory(R.layout.fragment_avia_tickets) {
    private lateinit var getMusicTravelsUseCase: GetMusicTravelsUseCase

    //    private lateinit var mv: AviaTicketsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getMusicTravelsUseCase = GetMusicTravelsUseCase(MusicTravelRepositoryImpl(requireContext()))

//        mv = ViewModelProvider(this, AviaTicketsViewModelFactory()).get(AviaTicketsViewModel::class.java)

        val items = mutableListOf<ItemMusicTravelModel>()
        lifecycleScope.launch {
            items.addAll(getMusicTravelsUseCase.execute())
        }

        view.findViewById<RecyclerView>(R.id.recycler_view_music_travel)
            .apply {
                layoutManager =
                    LinearLayoutManager(
                        view.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                adapter = MusicTravelAdapter(items)
            }
    }
}