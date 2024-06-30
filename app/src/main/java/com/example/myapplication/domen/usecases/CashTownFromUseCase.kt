package com.example.myapplication.domen.usecases

import com.example.myapplication.domen.repositories.TownFromRepository

class CashTownFromUseCase(private val repository: TownFromRepository) {
    fun get(): String {
        return repository.getTown()
    }

    fun set(town: String){
        repository.setTown(town)
    }
}