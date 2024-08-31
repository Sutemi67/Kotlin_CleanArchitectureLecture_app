package com.example.data.storage

import com.example.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}