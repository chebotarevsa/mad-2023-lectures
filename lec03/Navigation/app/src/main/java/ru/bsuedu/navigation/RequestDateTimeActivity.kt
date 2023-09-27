package ru.bsuedu.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.navigation.databinding.ActivityRequestDateTimeBinding

class RequestDateTimeActivity : AppCompatActivity() {

    lateinit var binding: ActivityRequestDateTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDateTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text = intent.extras?.getString(EXTRAS_DATE_TIME)

        binding.button.setOnClickListener {
            val intent = Intent().apply {
                putExtra(EXTRAS_DATE_TIME, binding.editTextText.text.toString())
            }
            setResult(
                RESULT_OK,
                intent
            )
            finish()
        }
    }
}