package ru.bsuedu.lec04.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import ru.bsuedu.lec04.listview.core.toast
import ru.bsuedu.lec04.listview.data.DataProvider
import ru.bsuedu.lec04.listview.data.DataProvider.KEY_INDEX
import ru.bsuedu.lec04.listview.data.DataProvider.KEY_NAME
import ru.bsuedu.lec04.listview.databinding.ActivitySimpleAdapterBinding

class SimpleAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleAdapterBinding
    private lateinit var simpleAdapter: SimpleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        simpleAdapter = SimpleAdapter(
            this,
            DataProvider.simpleDataList,
            android.R.layout.simple_list_item_2,
            arrayOf(KEY_INDEX, KEY_NAME),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.lvListContainer.adapter = simpleAdapter

        binding.lvListContainer.setOnItemClickListener { parent, view, position, id ->
            toast("Click $position")
            // Удаление элемента списка
            DataProvider.simpleDataList.removeAt(position)
            simpleAdapter.notifyDataSetChanged()
        }

        binding.fabAdd.setOnClickListener {
            // Добавление элемента
            DataProvider.simpleDataList.add(0, mapOf(KEY_INDEX to "NEW", KEY_NAME to "Item NEW"))
            simpleAdapter.notifyDataSetChanged()
        }

    }

}
