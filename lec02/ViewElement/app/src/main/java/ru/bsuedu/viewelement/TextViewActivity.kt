package ru.bsuedu.viewelement

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
// 01
class TextViewActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        textView = findViewById(R.id.textview)
        textView.setTextColor(Color.BLACK)
    }
}