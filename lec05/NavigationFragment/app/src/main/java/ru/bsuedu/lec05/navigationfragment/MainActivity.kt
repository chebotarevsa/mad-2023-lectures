package ru.bsuedu.lec05.navigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec05.navigationfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}