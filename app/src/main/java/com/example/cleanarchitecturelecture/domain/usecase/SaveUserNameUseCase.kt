package com.example.cleanarchitecturelecture.domain.usecase

import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams

class SaveUserNameUseCase {
    fun execute(params: SaveUserNameParams): Boolean {
        return params.name.isNotEmpty()
    }
}