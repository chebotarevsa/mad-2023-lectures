package ru.bsuedu.viewelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.viewelement.databinding.ActivityImageViewBinding
//03
class ImageViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binging.imageView.setImageResource(R.drawable.photo)

//        Glide
//            .with(this)
//            .load("https://loremflickr.com/320/240")
//            .into(binging.imageView)
    }
}