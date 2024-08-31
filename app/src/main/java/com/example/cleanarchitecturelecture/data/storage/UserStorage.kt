package com.example.cleanarchitecturelecture.data.storage

import com.example.cleanarchitecturelecture.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}