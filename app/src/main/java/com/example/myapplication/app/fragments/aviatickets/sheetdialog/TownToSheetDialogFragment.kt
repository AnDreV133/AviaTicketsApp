package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.app.fragments.aviatickets.TownFromToShareViewModel
import com.example.myapplication.app.fragments.aviatickets.TownFromToShareViewModelFactory
import com.example.myapplication.app.utils.BaseBottomSheetDialogFragment

class TownToSheetDialogFragment : BaseBottomSheetDialogFragment(
    R.layout.sheet_dialog_town_to
) {
    private lateinit var townToSheetDialogViewModel: TownToSheetDialogViewModel
    private lateinit var townFromToShareViewModel: TownFromToShareViewModel
    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText

    private lateinit var recyclerViewPopularTowns: RecyclerView
    private lateinit var imgBtnHardRoute: ImageView
    private lateinit var imgBtnWeekend: ImageView
    private lateinit var imgBtnHotTickets: ImageView
    private lateinit var imgBtnAnywhere: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextFrom = view.findViewById(R.id.sheet_dialog_edit_text_town_from)
        editTextTo = view.findViewById(R.id.sheet_dialog_edit_text_town_to)
        recyclerViewPopularTowns = view.findViewById(R.id.sheet_dialog_recycler_view_popular_towns)
        imgBtnHardRoute = view.findViewById(R.id.sheet_dialog_town_to_hard_route)
        imgBtnWeekend = view.findViewById(R.id.sheet_dialog_town_to_weekends)
        imgBtnAnywhere = view.findViewById(R.id.sheet_dialog_town_to_anywhere)
        imgBtnHotTickets = view.findViewById(R.id.sheet_dialog_town_to_hot_tickets)

        townFromToShareViewModel = ViewModelProvider(
            requireActivity(),
            TownFromToShareViewModelFactory(requireContext())
        )[TownFromToShareViewModel::class.java]

        townToSheetDialogViewModel = ViewModelProvider(
            this,
            TownToSheetDialogViewModelFactory(requireContext())
        )[TownToSheetDialogViewModel::class.java]

        townFromToShareViewModel.state.observe(viewLifecycleOwner) { model ->
            editTextFrom.setText(model.townFrom)
            editTextTo.setText(model.townTo)
        }

        townToSheetDialogViewModel.state.observe(viewLifecycleOwner) { model ->
            recyclerViewPopularTowns.apply {
                layoutManager = LinearLayoutManager(
                    view.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                adapter = PopularTownsAdapter(model.items)
            }
        }

        editTextFrom.apply {
            setInputType(EditorInfo.TYPE_NULL)
            setOnClickListener {
                dismiss()
            }
        }

        editTextTo.apply {
            requestFocus()
        }

        imgBtnHardRoute.setOnClickListener {
            findNavController().navigate(
                R.id.action_nav_menu_item_avia_tickets_to_nav_fragment_hard_route
            )

            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        townFromToShareViewModel.apply {
            updateTownFrom(editTextFrom.text)
            updateTownTo(editTextTo.text)
        }
    }
}