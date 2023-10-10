package ru.bsuedu.lab04.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bsuedu.lab04.recyclerview.adapter.DiffUtilUserAdapter
import ru.bsuedu.lab04.recyclerview.data.UserRepository
import ru.bsuedu.lab04.recyclerview.databinding.ActivityDiffUtilRecyclerViewBinding

class DiffUtilRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiffUtilRecyclerViewBinding
    private lateinit var adapter: DiffUtilUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiffUtilRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DiffUtilUserAdapter()
        adapter.users = UserRepository.users
        adapter.setOnDeleteUser {
            UserRepository.remove(it)
            adapter.users = UserRepository.users
        }

        binding.rvSimple.adapter = adapter
        binding.rvSimple.layoutManager = LinearLayoutManager(this)

        binding.fabAdd.setOnClickListener {
            UserRepository.add()
            adapter.users = UserRepository.users
        }

    }
}