package ru.bsuedu.lab04.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lab04.recyclerview.databinding.ActivityMainBinding
import ru.bsuedu.lab04.recyclerview.databinding.ActivitySimpleRecyclerViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnSimpleRecycleView.setOnClickListener {
            startActivity(Intent(this, SimpleRecyclerViewActivity::class.java))
        }

        binding.bnModifyRecycleView.setOnClickListener {
            startActivity(Intent(this, ModifyRecyclerViewActivity::class.java))
        }

        binding.bnDiffUtilRecycleView.setOnClickListener {
            startActivity(Intent(this, DiffUtilRecyclerViewActivity::class.java))
        }
    }
}