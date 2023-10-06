package ru.bsuedu.lec04.naivelist.data

import android.graphics.Color
import kotlin.random.Random

object ItemRepository {
    private val _data = (1..5000).map { createNew(it) }.toMutableList()

    val data
        get() = _data.toList()

    fun remove(name: String): List<ItemModel> = _data.apply { removeIf { it.name == name } }
    fun addRandom(): List<ItemModel> = _data.apply { add(0, createRandom()) }

    private fun createNew(index: Int): ItemModel = ItemModel(
        id = index.toLong(),
        name = "Item $index",
        color = randomColor()
    )

    private fun createRandom(): ItemModel = Random.nextLong().let {
        ItemModel(
            id = it,
            name = "Item $it",
            color = randomColor()
        )
    }

    private fun randomColor(): Int = Color.argb(
        255,
        Random.nextInt(256),
        Random.nextInt(256),
        Random.nextInt(256),
    )

}