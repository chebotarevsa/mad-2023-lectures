package ru.bsuedu.dynamicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Group
        val linearLayout = LinearLayout(this)
        val linearLayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        linearLayout.layoutParams = linearLayoutParams
        linearLayout.gravity = Gravity.CENTER
        // Text
        val textView = TextView(this)
        val textViewParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView.layoutParams = textViewParams
        textView.id = R.id.text
        textView.setTextColor(resources.getColor(R.color.black, theme))
        textView.text = resources.getText(R.string.hello_world)
        textView.textSize = resources.getDimension(R.dimen.text_size)

        linearLayout.addView(textView)

        setContentView(linearLayout)
    }
}