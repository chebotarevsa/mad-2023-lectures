package ru.bsuedu.lec05.simplenavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.bsuedu.lec05.simplenavigationfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun goToRed(message: String) {
        val redFragment = RedFragment.createInstance(message)
        supportFragmentManager.commit {
            replace(R.id.container, redFragment)
            setReorderingAllowed(true)
            addToBackStack("main")
        }
    }

    override fun goToGreen(message: String) {
        val greenFragment = GreenFragment.createInstance(message)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, greenFragment)
            .setReorderingAllowed(true)
            .addToBackStack("main")
            .commit()
    }
}


interface Navigator {
    fun goToRed(message: String)
    fun goToGreen(message: String)
}