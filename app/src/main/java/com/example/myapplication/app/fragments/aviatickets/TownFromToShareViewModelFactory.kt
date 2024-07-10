package com.example.myapplication.app.fragments.aviatickets

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.CashTownFromUseCase
import com.example.myapplication.repositories.TownFromRepositoryImpl


class TownFromToShareViewModelFactory(val context: Context) : ViewModelProvider.Factory {

    private val cashTownFromUseCase by lazy(LazyThreadSafetyMode.NONE)  {
        CashTownFromUseCase(TownFromRepositoryImpl(context))
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TownFromToShareViewModel(
            cashTownFromUseCase = cashTownFromUseCase
        ) as T
    }
}