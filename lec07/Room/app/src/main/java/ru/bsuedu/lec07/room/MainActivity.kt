package ru.bsuedu.lec07.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec07.room.data.User
import ru.bsuedu.lec07.room.data.UserDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}