package com.example.domain.usecase

import com.example.domain.models.SaveUserNameParams
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(params: SaveUserNameParams): Boolean {
        val result: Boolean = userRepository.saveName(saveUserNameParams = params)
        return result
    }
}