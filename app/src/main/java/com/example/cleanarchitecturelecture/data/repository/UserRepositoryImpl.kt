package com.example.cleanarchitecturelecture.data.repository

import android.content.Context
import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams
import com.example.cleanarchitecturelecture.domain.models.UserName
import com.example.cleanarchitecturelecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name_key"
private const val KEY_LAST_NAME = "last_name_key"
private const val DEFAULT_NAME = "Default"

//В слое дата никакой логики, только получение/сохранение данных

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserNameParams: SaveUserNameParams): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveUserNameParams.firstName).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}