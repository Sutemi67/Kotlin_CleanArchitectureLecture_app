package com.example.cleanarchitecturelecture.domain.repository

import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams
import com.example.cleanarchitecturelecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveUserNameParams: SaveUserNameParams): Boolean
    fun getName(): UserName
}