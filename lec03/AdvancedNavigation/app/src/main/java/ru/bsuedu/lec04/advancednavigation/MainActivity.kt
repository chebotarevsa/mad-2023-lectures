package ru.bsuedu.lec04.advancednavigation

import android.app.ActivityManager
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.advancednavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var activityManager: ActivityManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        binding.bnTaskInfo.setOnClickListener {
            Utils.printTaskInfo(activityManager, TAG)
        }

        binding.bnNavToSecondActivityCurrentTask.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.bnNavToSecondActivityNewTask.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                flags = FLAG_ACTIVITY_NEW_TASK
            }.also {
                startActivity(it)
            }
        }
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}