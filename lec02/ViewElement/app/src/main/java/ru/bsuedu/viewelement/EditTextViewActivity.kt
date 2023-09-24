package ru.bsuedu.viewelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.bsuedu.viewelement.databinding.ActivityEditTextViewBinding
//05
class EditTextViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditTextViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            showRandomImage()
        }

        binding.button.setOnLongClickListener {
            showInfo()
        }

        binding.text.setOnEditorActionListener { v, actionId, event ->
            showRandomImage()
            false
         }
    }

    private fun showRandomImage() {
        val type = binding.text.text.toString().ifBlank { "paris" }
        Glide
            .with(this)
            .load("https://loremflickr.com/g/320/240/$type")
            .placeholder(R.drawable.ic_launcher_foreground)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)
    }

    private fun showInfo(): Boolean {
        Toast.makeText(this, "Long press", Toast.LENGTH_SHORT).show()
        return true
    }

}