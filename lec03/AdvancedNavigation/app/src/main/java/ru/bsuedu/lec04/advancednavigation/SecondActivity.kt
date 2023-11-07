package ru.bsuedu.lec04.advancednavigation

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.advancednavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var activityManager: ActivityManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        Utils.printTaskInfo(activityManager, MainActivity.TAG)

        binding.bnNavToThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}