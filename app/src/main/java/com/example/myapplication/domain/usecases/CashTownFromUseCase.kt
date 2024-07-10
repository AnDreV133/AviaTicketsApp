package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.TownFromRepository

class CashTownFromUseCase(private val repository: TownFromRepository) {
    fun get(): String {
        return repository.getTown()
    }

    fun set(town: String){
        repository.setTown(town)
    }
}