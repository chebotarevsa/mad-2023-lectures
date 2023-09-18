package ru.bsuedu.lifecycle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.bsuedu.lifecycle.databinding.ActivityMainBinding
import ru.bsuedu.lifecycle.databinding.ActivitySeconBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeconBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $savedInstanceState")
        binding = ActivitySeconBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState $outState")
    }

    companion object {
        val TAG = SecondActivity::class.simpleName

        fun createIntent(context:Context):Intent =
            Intent(context,SecondActivity::class.java)
    }

}