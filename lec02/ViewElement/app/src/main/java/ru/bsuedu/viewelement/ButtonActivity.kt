package ru.bsuedu.viewelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.bsuedu.viewelement.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
          showRandomImage()
        }

        binding.button.setOnLongClickListener {
            showInfo()
        }

    }

    private fun showRandomImage() {
        Glide
            .with(this)
            .load("https://loremflickr.com/g/320/240/paris")
            .placeholder(R.drawable.ic_launcher_background)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)
    }

    private fun showInfo():Boolean{
        Toast.makeText(this,"Long press", Toast.LENGTH_SHORT).show()
        return true
    }
}