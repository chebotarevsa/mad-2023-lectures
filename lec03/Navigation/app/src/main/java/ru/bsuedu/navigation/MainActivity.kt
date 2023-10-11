package ru.bsuedu.navigation

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import ru.bsuedu.navigation.contract.DateTimeContract
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
            Intent().apply {
                setClass(this@MainActivity, DateTimeActivity::class.java)
                putExtra(EXTRAS_DATE_TIME, dateAsText)
               // flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }.also {
                startActivity(it)
            }

        }

        // Неявный Intent
        binding.imButton.setOnClickListener {
            Intent().apply {
                action = ACTION_SHOW_DATE
                addCategory(Intent.CATEGORY_DEFAULT)
                putExtra(EXTRAS_DATE_TIME, dateAsText)
            }.also {
                startActivity(it)
            }

        }

        // Неявный системный Intent
        binding.cmButton.setOnClickListener {
            Intent().apply {
                action = ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dateAsText)
                type = "text/plain"
            }.also {
                startActivity(it)
            }

        }

        // Вызов активности для получение результата - устаревший способ
        binding.reButton.setOnClickListener {
            Intent().apply {
                setClass(this@MainActivity, RequestDateTimeActivity::class.java)
                replaceExtras(bundleOf(EXTRAS_DATE_TIME to dateAsText))
            }.also {
                startActivityForResult(it, REQUEST_DATE_TIME)
            }

        }

        binding.re2Button.setOnClickListener {
            getDateTimeContent.launch(dateAsText)
        }

        binding.cm2Button.setOnClickListener {
            getSystemContent.launch("image/*")
        }
    }

    private val getDateTimeContent = registerForActivityResult(DateTimeContract()) {
        showToast(it.toString())
    }

    private val getSystemContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        showToast(it.toString())
        //1
        // val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, it)
        // 2.
        // val source = ImageDecoder.createSource(this.contentResolver, selectedPhotoUri)
        // ImageDecoder.decodeBitmap(source)
        // 3.
        // imageView.setImageURI(contentURI);
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