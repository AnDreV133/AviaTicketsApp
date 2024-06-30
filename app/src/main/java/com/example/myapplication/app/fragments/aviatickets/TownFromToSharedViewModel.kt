package com.example.myapplication.app.fragments.aviatickets

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domen.usecases.CashTownFromUseCase
import com.example.myapplication.domen.utils.TAG


class TownFromToSharedViewModel(
    private val cashTownFromUseCase: CashTownFromUseCase
) : ViewModel() {
    class Model(
        var townFrom: String = "",
        var townTo: String = "",
    )

    private val _state = MutableLiveData(Model())
    val state: LiveData<Model> = _state

    init {
        Log.d(TAG, "init TownFromToSharedViewModel")
        state.value?.townFrom = cashTownFromUseCase.get()
    }

    fun updateTownFrom(townFrom: String) {
        cashTownFromUseCase.set(townFrom)
        state.value?.townFrom = townFrom
    }

    fun updateTownTo(townTo: String) {
        state.value?.townTo = townTo
    }
}