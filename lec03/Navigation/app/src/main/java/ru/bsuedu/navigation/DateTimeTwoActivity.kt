package ru.bsuedu.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.navigation.databinding.ActivityDateTimeOneBinding
import ru.bsuedu.navigation.databinding.ActivityDateTimeTwoBinding

class DateTimeTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateTimeTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimeTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView3.text = intent.extras?.getString("TEST")
    }
}