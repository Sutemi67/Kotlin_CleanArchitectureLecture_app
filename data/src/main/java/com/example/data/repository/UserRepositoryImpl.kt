package com.example.data.repository

import com.example.data.storage.models.User
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserNameParams
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

// В слое дата никакой логики, только получение/сохранение данных
// К репозиторию только подключаем блоки с логикой (интекфейсы)
// Здесь мы подключили логику сохранения донных, если нужно будет еще подключить другой интерфейс, подключаем его в новое поле класса

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveUserNameParams: SaveUserNameParams): Boolean {
        val user =
            User(firstName = saveUserNameParams.firstName, lastName = saveUserNameParams.lastName)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}