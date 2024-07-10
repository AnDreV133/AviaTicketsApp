package com.example.myapplication.app.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.example.myapplication.domain.utils.TAG
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment(
    val res: Int
) : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $this")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG, "onCreateDialog $this")

        return BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView $this")

        return inflater.inflate(res, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated $this")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "onViewStateRestored $this")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart $this")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume $this")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause $this")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop $this")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState $this")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView $this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy $this")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach $this\n$context")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach $this")
    }
}