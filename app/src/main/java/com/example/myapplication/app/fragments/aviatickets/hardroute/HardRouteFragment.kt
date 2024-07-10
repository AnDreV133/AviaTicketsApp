package com.example.myapplication.app.fragments.aviatickets.hardroute

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.app.utils.BaseFragment

class HardRouteFragment : BaseFragment(
    R.layout.fragment_hard_route
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.hard_route_close).setOnClickListener {
            findNavController().popBackStack()
        }
    }
}