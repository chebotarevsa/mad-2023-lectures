package ru.bsuedu.lab04.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import ru.bsuedu.lab04.spinner.databinding.ActivityResourceSpinnerBinding

class ResourceSpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResourceSpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceSpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}