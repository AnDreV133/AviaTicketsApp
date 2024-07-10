package com.example.myapplication.app.fragments.aviatickets.sheetdialog

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.PopularTownRepositoryImpl
import com.example.myapplication.domain.usecases.GetPopularTownUseCase

class TownToSheetDialogViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {

    private fun getPopularTownUseCase() =
        GetPopularTownUseCase(
            PopularTownRepositoryImpl(
                context
            )
        )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TownToSheetDialogViewModel(
            getPopularTownUseCase = getPopularTownUseCase()
        ) as T
    }
}
