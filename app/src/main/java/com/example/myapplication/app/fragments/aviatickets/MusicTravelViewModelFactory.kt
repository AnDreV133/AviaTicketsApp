package com.example.myapplication.app.fragments.aviatickets

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.CashTownFromUseCase
import com.example.myapplication.domain.usecases.GetMusicTravelsUseCase
import com.example.myapplication.repositories.MusicTravelRepositoryImpl
import com.example.myapplication.repositories.TownFromRepositoryImpl

class MusicTravelViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    private val getMusicTravelsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetMusicTravelsUseCase(MusicTravelRepositoryImpl(context))
    }

    private val cashTownFromUseCase by lazy(LazyThreadSafetyMode.NONE)  {
        CashTownFromUseCase(TownFromRepositoryImpl(context))
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MusicTravelViewModel(
            getMusicTravelsUseCase = getMusicTravelsUseCase
        ) as T
    }
}