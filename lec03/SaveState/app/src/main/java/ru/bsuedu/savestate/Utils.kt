package ru.bsuedu.savestate

import android.graphics.Color
import kotlin.random.Random

object Utils {
    fun createRandomColor(): Int =
        Color.argb(255, Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))

    fun createRandomFontSize(): Float = Random.nextInt(100).toFloat()
}