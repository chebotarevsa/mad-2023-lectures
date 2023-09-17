package ru.bsuedu.viewelement

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.bsuedu.viewelement.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckBoxBinding
    private var isCategoryNeed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkbox.isChecked = isCategoryNeed

        binding.button.setOnClickListener {
            showRandomImage()
        }

        binding.button.setOnLongClickListener {
            showInfo()
        }

        binding.checkbox.setOnClickListener {
            isCategoryNeed = binding.checkbox.isChecked
            updateUI()
        }

        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->  }

        updateUI()

    }

    private fun updateUI(){
        when(isCategoryNeed){
            true -> binding.text.visibility = View.VISIBLE
            false -> binding.text.visibility = View.GONE
        }
    }

    private fun showRandomImage() {
        val type = binding.text.text.toString().trim()
        Glide
            .with(this)
            .load("https://loremflickr.com/320/240/$type")
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
