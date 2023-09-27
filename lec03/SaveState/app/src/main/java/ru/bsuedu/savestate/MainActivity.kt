package ru.bsuedu.savestate

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import ru.bsuedu.savestate.databinding.ActivityMainBinding
import kotlin.properties.Delegates
import kotlin.properties.Delegates.notNull
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var current:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = current.toString()

        binding.button.setOnClickListener {
            binding.textView.text = (++current).toString()
            binding.textView.setTextColor(createRandomColor())
            binding.textView.textSize = 100F
        }
    }

    private fun  createRandomColor():Int =
        Color.argb(255, Random.nextInt(255),Random.nextInt(255),Random.nextInt(255))

}