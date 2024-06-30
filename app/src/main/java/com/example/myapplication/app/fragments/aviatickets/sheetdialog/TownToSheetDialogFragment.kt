package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.fragments.aviatickets.TownFromToSharedViewModel
import com.example.myapplication.app.fragments.aviatickets.TownFromToSharedViewModelFactory
import com.example.myapplication.app.master.MasterBottomSheetDialogFragment

class TownToSheetDialogFragment : MasterBottomSheetDialogFragment(
    R.layout.sheet_dialog_town_to
) {
    private lateinit var townToSheetDialogViewModel: TownToSheetDialogViewModel
    private lateinit var townFromToSharedViewModel: TownFromToSharedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo style has not effect
        setStyle(R.style.CustomBottomSheetStyle, R.style.CustomBottomSheetDialogTheme)

        townFromToSharedViewModel = ViewModelProvider(
            requireActivity(),
            TownFromToSharedViewModelFactory(requireContext())
        )[TownFromToSharedViewModel::class.java]

        townToSheetDialogViewModel = ViewModelProvider(
            this,
            TownToSheetDialogViewModelFactory(requireContext())
        )[TownToSheetDialogViewModel::class.java]

        townFromToSharedViewModel.state.observe(viewLifecycleOwner) { model ->
            view.findViewById<EditText>(R.id.edit_text_sheet_dialog_search_board_from).apply {
                setText(model.townFrom)
            }
        }

        townToSheetDialogViewModel.state.observe(viewLifecycleOwner) { model ->
            view.findViewById<RecyclerView>(R.id.recycler_view_sheet_dialog_town_to).apply {
                layoutManager =
                    LinearLayoutManager(
                        view.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )

                adapter = PopularTownAdapter(model.items)
            }
        }

        view.findViewById<ImageView>(R.id.sheet_dialog_town_to_hard_route).apply {
//            parentFragment?.findNavController()?.navigate(R.id.nav_fragment_hard_route)

        }


    }
}