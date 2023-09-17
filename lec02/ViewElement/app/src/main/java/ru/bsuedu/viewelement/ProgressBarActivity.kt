package ru.bsuedu.viewelement

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.bsuedu.viewelement.databinding.ActivityButtonBinding
import ru.bsuedu.viewelement.databinding.ActivityProgressBarBinding

class ProgressBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgressBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            showRandomImage()
        }

        binding.button.setOnLongClickListener {
            showInfo()
        }

    }

    private fun showRandomImage() {
        binding.progressCircular.visibility = View.VISIBLE
        Glide
            .with(this)
            .load("https://loremflickr.com/g/320/240/paris")
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressCircular.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressCircular.visibility = View.GONE
                    return false
                }

            })
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)
    }

    private fun showInfo():Boolean{
        Toast.makeText(this,"Long press", Toast.LENGTH_SHORT).show()
        return true
    }
}