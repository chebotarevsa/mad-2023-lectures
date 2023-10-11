package ru.bsuedu.savestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.bsuedu.savestate.databinding.ActivityWithoutStateBinding

class WithoutStateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWithoutStateBinding
    private var current: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState --- $savedInstanceState")
        binding = ActivityWithoutStateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = current.toString()

        binding.button.setOnClickListener {
            binding.textView.text = (++current).toString()
            binding.textView.setTextColor(Utils.createRandomColor())
            binding.textView.textSize = Utils.createRandomFontSize()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState --- $outState")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    companion object {
        val TAG = WithoutStateActivity::class.simpleName
    }
}