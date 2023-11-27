package ru.bsuedu.lec06.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
    }
}