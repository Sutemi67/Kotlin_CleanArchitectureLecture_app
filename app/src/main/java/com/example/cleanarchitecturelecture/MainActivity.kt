package com.example.cleanarchitecturelecture

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cleanarchitecturelecture.domain.models.SaveUserNameParams
import com.example.cleanarchitecturelecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturelecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

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
            val params = SaveUserNameParams(name = saveText)
            val result = saveUserNameUseCase.execute(params = params)
            nameText.text = "Save result = $result"
        }
        getButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            nameText.text = "${userName.firstName} ${userName.lastName}"
        }
    }

}