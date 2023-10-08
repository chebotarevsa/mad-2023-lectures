package ru.bsuedu.lec04.listview.data

data class ItemData(
    val id: Long,
    val name: String,
    val color: Int,
    val deletable: Boolean = false
)