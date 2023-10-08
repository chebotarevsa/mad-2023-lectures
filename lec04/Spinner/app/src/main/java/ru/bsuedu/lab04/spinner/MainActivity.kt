package ru.bsuedu.lab04.spinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lab04.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnResourceSpinner.setOnClickListener {
            startActivity(Intent(this, ResourceSpinnerActivity::class.java))
        }

        binding.bnCustomSpinner.setOnClickListener {
            startActivity(Intent(this, CustomSpinnerActivity::class.java))
        }
    }
}