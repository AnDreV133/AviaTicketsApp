package com.example.myapplication.app.fragments.aviatickets.weekend

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.app.utils.BaseFragment

class HardRouteFragment : BaseFragment(
    R.layout.fragment_weekend
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.weekend_close).setOnClickListener {
            this@HardRouteFragment.childFragmentManager.popBackStack()
        }
    }
}