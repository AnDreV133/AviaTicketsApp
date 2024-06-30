package com.example.myapplication.app.fragments.aviatickets.hardroute

import android.view.View
import com.example.myapplication.R
import com.example.myapplication.app.master.MasterFragment

class HardRouteFragment : MasterFragment(
    R.layout.fragment_avia_tickets_hard_route,
) {
    override fun onStart() {
        super.onStart()

        view?.findViewById<View>(R.id.sheet_dialog_town_to_hard_route)?.setOnClickListener {
//            this@HardRouteFragment.childFragmentManager.popBackStack()
        }
    }
}