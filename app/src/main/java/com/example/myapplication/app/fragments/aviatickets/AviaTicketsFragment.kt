package com.example.myapplication.app.fragments.aviatickets

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.fragments.aviatickets.sheetdialog.TownToSheetDialogFragment
import com.example.myapplication.app.master.MasterFragment
import com.example.myapplication.domen.utils.TAG


class AviaTicketsFragment
    : MasterFragment(
    R.layout.fragment_avia_tickets
) {
    private lateinit var musicTravelViewModel: MusicTravelViewModel
    private lateinit var townFromToSharedViewModel: TownFromToSharedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        musicTravelViewModel = ViewModelProvider(
            this,
            MusicTravelViewModelFactory(requireContext())
        )[MusicTravelViewModel::class.java]

        townFromToSharedViewModel = ViewModelProvider(
            requireActivity(),
            TownFromToSharedViewModelFactory(requireContext())
        )[TownFromToSharedViewModel::class.java]

        townFromToSharedViewModel.state.observe(viewLifecycleOwner) { model ->
            view.findViewById<EditText>(R.id.edit_text_from).apply {
                setText(model.townFrom)
            }

            view.findViewById<EditText>(R.id.edit_text_to).apply {
                setOnFocusChangeListener { _, _ ->
                    TownToSheetDialogFragment().show(childFragmentManager, "town to sheet dialog")
                }
            }
        }

        musicTravelViewModel.state.observe(viewLifecycleOwner) { model ->
            view.findViewById<RecyclerView>(R.id.recycler_view_music_travel)
                .apply {
                    layoutManager =
                        LinearLayoutManager(
                            view.context,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )

                    adapter = MusicTravelAdapter(model.items)
                }
        }
    }

    override fun onStop() {
        super.onStop()

        townFromToSharedViewModel.updateTownFrom(
            view?.findViewById<EditText>(R.id.edit_text_from)
                ?.text?.trim().toString()
        )
    }
}