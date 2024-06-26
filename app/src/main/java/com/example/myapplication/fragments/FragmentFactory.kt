package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class FragmentFactory(
    private val res: Int
) : Fragment() {
    companion object {
        fun newInstance(res: Int) = FragmentFactory(res)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        Log.d("FragmentFactory", "fragment $res been created")
        return inflater.inflate(res, container, false)
    }
}
