package ru.bsuedu.viewelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.bsuedu.viewelement.databinding.ActivityButtonBinding
import ru.bsuedu.viewelement.databinding.ActivityRadioButtonBinding

class RadioButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRadioButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }

    private fun initUI(){
        binding.cat.isChecked = true
        showRandomImage(getTextFormRadioButton(binding.cat))

        binding.group.setOnCheckedChangeListener { group, checkedId ->
            val id = group.checkedRadioButtonId
            val checked = group.findViewById<RadioButton>(id)
            showRandomImage(getTextFormRadioButton(checked))
        }
    }

    private fun getTextFormRadioButton(button: RadioButton) =
        button.text.toString().lowercase().trim()

    private fun showRandomImage(category:String) {
        Glide
            .with(this)
            .load("https://loremflickr.com/g/320/240/$category")
            .placeholder(R.drawable.ic_launcher_background)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)
    }
}