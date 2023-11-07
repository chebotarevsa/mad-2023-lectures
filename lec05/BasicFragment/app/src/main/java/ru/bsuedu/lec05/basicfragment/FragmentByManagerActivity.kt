package ru.bsuedu.lec05.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import ru.bsuedu.lec05.basicfragment.databinding.ActivityFragmentByManagerBinding

class FragmentByManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentByManagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentByManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fr_manager_container, ManagerFragment.newInstance("test1", "test2"))
            .commit()
    }
}