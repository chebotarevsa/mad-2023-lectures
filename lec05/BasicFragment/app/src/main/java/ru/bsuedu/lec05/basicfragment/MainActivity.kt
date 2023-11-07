package ru.bsuedu.lec05.basicfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec05.basicfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnWithName.setOnClickListener {
            Intent(this, FragmentByNameActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.bnWithFm.setOnClickListener {
            Intent(this, FragmentByManagerActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.bnWithLifecycle.setOnClickListener {
            Intent(this, LifecycleActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}