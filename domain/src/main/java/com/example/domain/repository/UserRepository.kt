package com.example.domain.repository

import com.example.domain.models.SaveUserNameParams
import com.example.domain.models.UserName

interface UserRepository {
    fun saveName(saveUserNameParams: SaveUserNameParams): Boolean
    fun getName(): UserName
}