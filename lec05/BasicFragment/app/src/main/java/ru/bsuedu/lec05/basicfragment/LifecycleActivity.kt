package ru.bsuedu.lec05.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "Lifecycle"

//package:mine & tag:Lifecycle
class LifecycleActivity : AppCompatActivity() {
    private var lifecycleFragment: LifecycleFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "Activity - onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        if (lifecycleFragment == null) {
            lifecycleFragment = LifecycleFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fr_lifecycle_container, lifecycleFragment!!)
                .setReorderingAllowed(true)
                .commit()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Activity - onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Activity - onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Activity - onStop")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Activity - onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Activity - onResume")
    }

}