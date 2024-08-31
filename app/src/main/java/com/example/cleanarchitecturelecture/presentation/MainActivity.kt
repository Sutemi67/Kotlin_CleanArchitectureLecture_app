package com.example.cleanarchitecturelecture.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cleanarchitecturelecture.R
import com.example.cleanarchitecturelecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturelecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams
import com.example.cleanarchitecturelecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturelecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    //в слое presentation мы инициализируем все зависимости и работает только над тем, что юзер тыкает
    //в UI. Так же работаем с самим UI изменяя по необходимости эти элементы.

    //by lazy означает создание класса по мере необходимости
    private val sharedPreferencesUserStorage by lazy { SharedPrefUserStorage(this) }
    private val userRepository by lazy { UserRepositoryImpl(sharedPreferencesUserStorage) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getButton = findViewById<Button>(R.id.get_button)
        val saveButton = findViewById<Button>(R.id.save_button)
        val nameText = findViewById<TextView>(R.id.name_text)
        val input = findViewById<EditText>(R.id.input)

        saveButton.setOnClickListener {
            val saveText = input.text.toString()
            val params = SaveUserNameParams(firstName = saveText, lastName = "Last")
            val result = saveUserNameUseCase.execute(params = params)
            nameText.text = "Save result = $result"
        }
        getButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            nameText.text = "${userName.firstName} ${userName.lastName}"
        }
    }

}