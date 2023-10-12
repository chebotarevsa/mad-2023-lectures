package ru.bsuedu.lec04.advancednavigation

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.advancednavigation.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var activityManager: ActivityManager
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        Utils.printTaskInfo(activityManager, MainActivity.TAG)

        binding.bnNavToFourth.setOnClickListener {
            Intent(this, FourthActivity::class.java).apply {

            }.also {
                startActivity(it)
            }
        }
    }
}