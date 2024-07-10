package com.example.myapplication.app.fragments.aviatickets

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.fragments.aviatickets.sheetdialog.TownToSheetDialogFragment
import com.example.myapplication.app.utils.BaseFragment
import com.example.myapplication.domain.utils.TAG


class AviaTicketsFragment
    : BaseFragment(
    R.layout.fragment_avia_tickets
) {
    private lateinit var musicTravelViewModel: MusicTravelViewModel
    private lateinit var townFromToShareViewModel: TownFromToShareViewModel

    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var recyclerViewMusicTravel: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        musicTravelViewModel = ViewModelProvider(
            this,
            MusicTravelViewModelFactory(requireContext())
        )[MusicTravelViewModel::class.java]

        townFromToShareViewModel = ViewModelProvider(
            requireActivity(),
            TownFromToShareViewModelFactory(requireContext())
        )[TownFromToShareViewModel::class.java]

        editTextFrom = view.findViewById(R.id.edit_text_from)
        editTextTo = view.findViewById(R.id.edit_text_to)
        recyclerViewMusicTravel = view.findViewById(R.id.recycler_view_music_travel)

        townFromToShareViewModel.state.observe(viewLifecycleOwner) { model ->
            editTextFrom.setText(model.townFrom)
            editTextTo.setText(model.townTo)
        }

        musicTravelViewModel.state.observe(viewLifecycleOwner) { model ->
            recyclerViewMusicTravel.apply {
                layoutManager = LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                adapter = MusicTravelAdapter(model.items)
            }
        }

        editTextTo.apply {
            setInputType(EditorInfo.TYPE_NULL)
            setOnClickListener {
                townFromToShareViewModel.updateTownFrom(editTextFrom.text)

                TownToSheetDialogFragment().show(parentFragmentManager, "sheetDialog")
            }
        }
    }

    override fun onPause() {
        super.onPause()

        editTextFrom.also { v ->
            townFromToShareViewModel.updateTownFrom(v.text)
        }

        editTextTo.also { v ->
            townFromToShareViewModel.updateTownTo(v.text)
        }
    }
}