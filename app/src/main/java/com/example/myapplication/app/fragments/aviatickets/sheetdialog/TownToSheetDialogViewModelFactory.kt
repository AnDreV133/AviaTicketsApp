package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domen.usecases.GetPopularTownUseCase
import com.example.myapplication.repositories.PopularTownRepositoryImpl

class TownToSheetDialogViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {

    private fun getPopularTownUseCase() =
        GetPopularTownUseCase(PopularTownRepositoryImpl(context))

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TownToSheetDialogViewModel(
            getPopularTownUseCase = getPopularTownUseCase()
        ) as T
    }
}
