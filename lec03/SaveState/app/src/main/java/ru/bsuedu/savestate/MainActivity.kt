package ru.bsuedu.savestate

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.TypedValue
import androidx.annotation.RequiresApi
import ru.bsuedu.savestate.databinding.ActivityMainBinding
import ru.bsuedu.savestate.databinding.ActivityWithoutStateBinding
import kotlin.properties.Delegates
import kotlin.properties.Delegates.notNull
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnWithoutSaveState.setOnClickListener {
            startActivity(Intent(this, WithoutStateActivity::class.java))
        }

        binding.bnWithSaveSate.setOnClickListener {
            startActivity(Intent(this, WithStateActivity::class.java))
        }
    }

}