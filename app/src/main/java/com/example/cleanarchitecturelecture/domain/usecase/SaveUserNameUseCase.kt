package com.example.cleanarchitecturelecture.domain.usecase

import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams
import com.example.cleanarchitecturelecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(params: SaveUserNameParams): Boolean {
        val result: Boolean = userRepository.saveName(saveUserNameParams = params)
        return result
    }
}