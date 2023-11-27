package ru.bsuedu.lec06.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleEventObserver

class MainActivity : AppCompatActivity() {
    private val eventObserver: LifecycleEventObserver = MyLifecycleEventObserver()
    private val defaultObserver: DefaultLifecycleObserver = MyDefaultLifecycleObserver()
    override fun onCreate(savedInstanceState: Bundle?) {
        this.lifecycle.addObserver(eventObserver)
        this.lifecycle.addObserver(defaultObserver)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
