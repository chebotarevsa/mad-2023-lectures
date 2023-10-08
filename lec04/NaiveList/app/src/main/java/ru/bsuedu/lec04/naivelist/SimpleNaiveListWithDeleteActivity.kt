package ru.bsuedu.lec04.naivelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ru.bsuedu.lec04.naivelist.data.ItemModel
import ru.bsuedu.lec04.naivelist.data.ItemRepository

class SimpleNaiveListWithDeleteActivity : AppCompatActivity() {

    private lateinit var listContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_naive_list_with_delete)
        listContainer = findViewById(R.id.ll_list_container)
        buildList(listContainer, R.layout.item_view, R.id.tv_item_text, ItemRepository.data)
    }

    private fun buildList(
        parent: ViewGroup,
        resource: Int,
        textViewId: Int,
        data: List<ItemModel>
    ) {
        parent.removeAllViews()

        data.map { dataItem ->
            val listItem = layoutInflater.inflate(resource, parent, false)

            val text = listItem.findViewById<TextView>(textViewId)
            text.text = dataItem.name
            text.setTextColor(dataItem.color)

            val deleteIcon = listItem.findViewById<ImageView>(R.id.iv_delete_icon)
            deleteIcon.setOnClickListener(::deleteItem)

            listItem
        }.forEach {
            parent.addView(it)
        }
    }

    private fun deleteItem(currentView: View) {
        val currentParent = currentView.parent as View
        val currentText = currentParent.findViewById<TextView>(R.id.tv_item_text)
        ItemRepository.remove(currentText.text.toString())
        buildList(listContainer, R.layout.item_view, R.id.tv_item_text, ItemRepository.data)
    }
}