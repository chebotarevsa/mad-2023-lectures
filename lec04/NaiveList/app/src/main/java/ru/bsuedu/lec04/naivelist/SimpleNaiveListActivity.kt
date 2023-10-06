package ru.bsuedu.lec04.naivelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import ru.bsuedu.lec04.naivelist.data.ItemModel
import ru.bsuedu.lec04.naivelist.data.ItemRepository

class SimpleNaiveListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_naive_list)
        val listContainer = findViewById<LinearLayout>(R.id.ll_list_container)
        buildList(listContainer, R.layout.item_view, R.id.tv_item_text, ItemRepository.data)
    }

    private fun buildList(parent: ViewGroup, resource: Int, textViewId: Int, data: List<ItemModel>) {
        data.map { dataItem ->
            val listItem = layoutInflater.inflate(resource, parent, false)
            val text = listItem.findViewById<TextView>(textViewId)
            text.text = dataItem.name
            text.setTextColor(dataItem.color)
            listItem
        }.forEach {
            parent.addView(it)
        }
    }
}