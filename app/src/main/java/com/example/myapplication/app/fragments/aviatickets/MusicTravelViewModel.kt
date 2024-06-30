package com.example.myapplication.app.fragments.aviatickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domen.models.ItemMusicTravelModel
import com.example.myapplication.domen.usecases.GetMusicTravelsUseCase
import kotlinx.coroutines.launch



class MusicTravelViewModel(
    private val getMusicTravelsUseCase: GetMusicTravelsUseCase
) : ViewModel() {
    class Model(
        val items: MutableList<ItemMusicTravelModel> = mutableListOf()
    )

    private val _state = MutableLiveData(Model())
    val state: LiveData<Model> = _state

    init {
        viewModelScope.launch {
            state.value?.items?.addAll(getMusicTravelsUseCase.get())
        }
    }
}