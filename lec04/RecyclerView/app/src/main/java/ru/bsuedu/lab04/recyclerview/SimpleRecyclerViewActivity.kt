package ru.bsuedu.lab04.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bsuedu.lab04.recyclerview.adapter.SimpleUserAdapter
import ru.bsuedu.lab04.recyclerview.data.UserRepository
import ru.bsuedu.lab04.recyclerview.databinding.ActivitySimpleRecyclerViewBinding

class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    private lateinit var adapter: SimpleUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SimpleUserAdapter()
        adapter.users = UserRepository.users

        binding.rvSimple.adapter = adapter
        binding.rvSimple.layoutManager = LinearLayoutManager(this)
    }
}