package ru.bsuedu.lec04.listview.data

import android.graphics.Color
import kotlin.random.Random

object DataProvider {
    const val KEY_INDEX = "INDEX"
    const val KEY_NAME = "NAME"

    private val _dataList = (1..3).map {
        createNew(it)
    }.toMutableList()

    val dataList
        get() = _dataList

    val simpleDataList = (1..100_000).map {
        mapOf(
            KEY_INDEX to it.toString(),
            KEY_NAME to "Item $it"
        )
    }.toMutableList()


    fun createNew(init: Int) =
        ItemData(
            init.toLong(),
            "Item $init",
            randomColor(),
        )

    fun createNew() =
        Random.nextInt().let { init ->
            ItemData(
                init.toLong(),
                "Item $init",
                randomColor(),
                true
            )
        }

    private fun randomColor(): Int = Color.argb(
        255,
        Random.nextInt(256),
        Random.nextInt(256),
        Random.nextInt(256),
    )
}