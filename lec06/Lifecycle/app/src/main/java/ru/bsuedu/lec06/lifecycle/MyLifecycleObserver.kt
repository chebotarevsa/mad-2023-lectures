package ru.bsuedu.lec06.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleEventObserver: LifecycleEventObserver{
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.i("LifecycleEventObserver", event.toString())
    }
}


class MyDefaultLifecycleObserver: DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onCreate $owner.lifecycle.currentState", )
        super.onCreate(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onDestroy $owner.lifecycle.currentState", )
        super.onDestroy(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onPause $owner.lifecycle.currentState", )
        super.onPause(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onResume $owner.lifecycle.currentState", )
        super.onResume(owner)
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onStart $owner.lifecycle.currentState", )
        super.onStart(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i("DefaultLifecycleObserver", "onStop $owner.lifecycle.currentState", )
        super.onStop(owner)
    }

}