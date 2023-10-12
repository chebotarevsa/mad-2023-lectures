package ru.bsuedu.lec04.advancednavigation

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.bsuedu.lec04.advancednavigation.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    private lateinit var activityManager: ActivityManager


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i(MainActivity.TAG, "New Intent $intent")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        Utils.printTaskInfo(activityManager, MainActivity.TAG)

        binding.bnNavToSelf.setOnClickListener {
            Intent(this,MainActivity::class.java).apply {
                //flags = Intent.FLAG_ACTIVITY_SINGLE_
            }.also {
                startActivity(it)
            }
        }
    }
}