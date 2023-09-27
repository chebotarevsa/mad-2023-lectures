package ru.bsuedu.navigation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import ru.bsuedu.navigation.databinding.ActivityDateTimeBinding
import ru.bsuedu.navigation.databinding.ActivityMainBinding
import java.util.Date

class DateTimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDateTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = intent.extras?.getString(EXTRAS_DATE_TIME)
    }

    companion object {
        fun createIntent(ctx: Context, date: Date): Intent {
            val dateAsText = date.toString()
            val intent = Intent().apply {
                setClass(ctx, DateTimeActivity::class.java)
                replaceExtras(bundleOf(EXTRAS_DATE_TIME to date))
            }
            return intent
        }
    }
}