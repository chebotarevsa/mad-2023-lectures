package ru.bsuedu.lec04.naivelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.naivelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bnTheMostNaiveList.setOnClickListener {
            startActivity(Intent(this, TheMostNaiveListActivity::class.java))
        }

        binding.bnSimpleNaiveList.setOnClickListener {
            startActivity(Intent(this, SimpleNaiveListActivity::class.java))
        }

        binding.bnSimpleNaiveListWithDelete.setOnClickListener {
            startActivity(Intent(this, SimpleNaiveListWithDeleteActivity::class.java))
        }
        binding.bnSimpleNaiveListWithAdd.setOnClickListener {
            startActivity(Intent(this, SimpleNaiveListWithAddActivity::class.java))
        }
    }
}