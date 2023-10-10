package ru.bsuedu.lab04.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bsuedu.lab04.recyclerview.adapter.ModifyUserAdapter
import ru.bsuedu.lab04.recyclerview.data.User
import ru.bsuedu.lab04.recyclerview.data.UserRepository
import ru.bsuedu.lab04.recyclerview.databinding.ActivityModifyRecyclerViewBinding

class ModifyRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModifyRecyclerViewBinding
    private lateinit var adapter: ModifyUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ModifyUserAdapter()
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