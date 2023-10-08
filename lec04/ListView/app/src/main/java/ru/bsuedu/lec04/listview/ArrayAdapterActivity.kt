package ru.bsuedu.lec04.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import ru.bsuedu.lec04.listview.core.toast
import ru.bsuedu.lec04.listview.data.DataProvider
import ru.bsuedu.lec04.listview.data.ItemData
import ru.bsuedu.lec04.listview.databinding.ActivityArrayAdapterBinding

class ArrayAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArrayAdapterBinding
    private lateinit var arrayAdapter: ArrayAdapter<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArrayAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, DataProvider.dataList)

//  Собственный layout
//        adapter = ArrayAdapter(
//            this,
//            R.layout.simply_array_adapter_item,
//            R.id.text1,
//            DataProvider.dateList
//        )
        binding.lvListContainer.adapter = arrayAdapter

        binding.lvListContainer.setOnItemClickListener { parent, view, position, id ->
            toast("Click $position")
            arrayAdapter.remove(arrayAdapter.getItem(position))
        }

        binding.fabAdd.setOnClickListener {
            arrayAdapter.add(DataProvider.createNew())
        }
    }
}
