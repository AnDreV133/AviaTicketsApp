package com.example.myapplication.app.fragments.aviatickets

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domen.usecases.CashTownFromUseCase
import com.example.myapplication.repositories.TownFromRepositoryImpl


class TownFromToSharedViewModelFactory(val context: Context) : ViewModelProvider.Factory {

    private val cashTownFromUseCase by lazy(LazyThreadSafetyMode.NONE)  {
        CashTownFromUseCase(TownFromRepositoryImpl(context))
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TownFromToSharedViewModel(
            cashTownFromUseCase = cashTownFromUseCase
        ) as T
    }
}