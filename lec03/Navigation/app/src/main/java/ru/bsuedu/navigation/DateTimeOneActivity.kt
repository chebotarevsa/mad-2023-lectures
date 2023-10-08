package ru.bsuedu.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.navigation.databinding.ActivityDateTimeBinding
import ru.bsuedu.navigation.databinding.ActivityDateTimeOneBinding

class DateTimeOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateTimeOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimeOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.text = intent.extras?.getString(EXTRAS_DATE_TIME)
    }
}