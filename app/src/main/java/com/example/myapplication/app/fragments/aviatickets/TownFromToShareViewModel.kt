package com.example.myapplication.app.fragments.aviatickets

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecases.CashTownFromUseCase


class TownFromToShareViewModel(
    private val cashTownFromUseCase: CashTownFromUseCase
) : ViewModel() {
    data class Model(
        var townFrom: String = "",
        var townTo: String = "",
    )

    private val _state = MutableLiveData(Model())
    val state: LiveData<Model> = _state

    init {
        Log.d(com.example.myapplication.domain.utils.TAG, "init $this")
        _state.value?.townFrom = cashTownFromUseCase.get()
    }

    fun updateTownFrom(townFrom: CharSequence) { // todo make validation
        townFrom.trim().toString().also { str ->
            cashTownFromUseCase.set(str)
            _state.value = _state.value?.copy(townFrom = str)

            Log.d(com.example.myapplication.domain.utils.TAG, "updateTownFrom $str")
        }
    }

    fun updateTownTo(townTo: CharSequence) {
        townTo.trim().toString().also { str ->
            _state.value = _state.value?.copy(townTo = str)

            Log.d(com.example.myapplication.domain.utils.TAG, "updateTownTo $str")
        }
    }
}