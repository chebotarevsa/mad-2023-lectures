package ru.bsuedu.navigation

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import ru.bsuedu.navigation.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dateAsText = Date().toString()

        // Явный Intent
        binding.exButton.setOnClickListener {
            val intent = Intent().apply {
                setClass(this@MainActivity, DateTimeActivity::class.java)
                replaceExtras(bundleOf(EXTRAS_DATE_TIME to dateAsText))
            }
            startActivity(DateTimeActivity.createIntent(this, Date()))
        }

        // Неявный Intent
        binding.imButton.setOnClickListener {
            val intent = Intent().apply {
                action = ACTION_SHOW_DATE
                addCategory(Intent.CATEGORY_DEFAULT)
                replaceExtras(bundleOf(EXTRAS_DATE_TIME to dateAsText))
            }
            startActivity(intent)
        }

        // Неявный системный Intent
        binding.cmButton.setOnClickListener {
            val intent = Intent().apply {
                action = ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dateAsText)
                type = "text/plain"
            }
            startActivity(intent)
        }

        // Вызов активности для получение результата - устаревший способ
        binding.reButton.setOnClickListener {
            val intent = Intent().apply {
                setClass(this@MainActivity, RequestDateTimeActivity::class.java)
                replaceExtras(bundleOf(EXTRAS_DATE_TIME to dateAsText))
            }
            startActivityForResult(intent, REQUEST_DATE_TIME)
        }

        // Вызов активности для получение результата - актуальный способ
        binding.re2Button.setOnClickListener {
            getContent.launch(dateAsText)
            //getSystemContent.launch("image/*")
        }
    }

    private val getContent = registerForActivityResult(DateTimeContract()) {
        showToast(it.toString())
    }

    private val getSystemContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        showToast(it.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_DATE_TIME && resultCode == RESULT_OK) {
            val result = data?.getStringExtra(EXTRAS_DATE_TIME)
            showToast(result)
        }
    }

    private fun showToast(value: String?): Unit {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }
}