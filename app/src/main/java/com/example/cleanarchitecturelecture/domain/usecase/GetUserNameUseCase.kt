package com.example.cleanarchitecturelecture.domain.usecase

import com.example.cleanarchitecturelecture.domain.models.UserName

class GetUserNameUseCase {
    fun execute() : UserName {
        return UserName(firstName = "Sergey", lastName = "Boykov")
    }
}