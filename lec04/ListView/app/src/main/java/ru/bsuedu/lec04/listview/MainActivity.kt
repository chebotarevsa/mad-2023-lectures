package ru.bsuedu.lec04.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnArrayAdapter.setOnClickListener {
            startActivity(Intent(this, ArrayAdapterActivity::class.java))
        }

        binding.bnSimpleAdapter.setOnClickListener {
            startActivity(Intent(this, SimpleAdapterActivity::class.java))
        }

        binding.bnCustomArrayAdapter.setOnClickListener {
            startActivity(Intent(this, CustomArrayAdapter::class.java))
        }

        binding.bnBaseAdapter.setOnClickListener {
            startActivity(Intent(this, BaseAdapterActivity::class.java))
        }

    }
}