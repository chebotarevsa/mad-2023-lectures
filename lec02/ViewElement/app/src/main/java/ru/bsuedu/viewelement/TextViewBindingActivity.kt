package ru.bsuedu.viewelement

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.bsuedu.viewelement.databinding.ActivityTextViewBindingBinding

class TextViewBindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityTextViewBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTextViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setTextColor(Color.RED)
        val text = binding.textView.text.toString()
        Log.d("TextViewBindingActivity", "Text - $text")

        binding.textView.text = "Новый текст"
        val textNew = binding.textView.text.toString()
        Log.d("TextViewBindingActivity", "Text - $textNew")
    }
}