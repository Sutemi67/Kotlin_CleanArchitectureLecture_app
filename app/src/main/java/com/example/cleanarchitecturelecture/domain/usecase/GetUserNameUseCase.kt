package com.example.cleanarchitecturelecture.domain.usecase

import com.example.cleanarchitecturelecture.domain.models.UserName
import com.example.cleanarchitecturelecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}