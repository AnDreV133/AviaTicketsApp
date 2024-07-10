package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.PopularTownModel
import com.example.myapplication.domain.usecases.GetPopularTownUseCase

class TownToSheetDialogViewModel(getPopularTownUseCase: GetPopularTownUseCase) : ViewModel() {
    class Model(
        val items: MutableList<PopularTownModel> = mutableListOf()
    )

    private val _state = MutableLiveData<Model>()
    val state: MutableLiveData<Model> = _state

}
