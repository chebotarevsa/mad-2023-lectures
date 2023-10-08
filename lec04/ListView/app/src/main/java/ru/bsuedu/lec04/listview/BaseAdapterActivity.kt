package ru.bsuedu.lec04.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.listview.adapter.CustomBaseAdapter
import ru.bsuedu.lec04.listview.core.toast
import ru.bsuedu.lec04.listview.data.DataProvider
import ru.bsuedu.lec04.listview.databinding.ActivityBaseAdapterBinding

class BaseAdapterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseAdapterBinding
    private lateinit var baseAdapter: CustomBaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        baseAdapter = CustomBaseAdapter(this, DataProvider.dataList) {
            DataProvider.dataList.remove(it)
            baseAdapter.notifyDataSetChanged()
        }
        
        binding.lvListContainer.adapter = baseAdapter

        binding.fabAdd.setOnClickListener {
            DataProvider.dataList.add(DataProvider.createNew())
            baseAdapter.notifyDataSetChanged()
        }

        binding.lvListContainer.setOnItemClickListener { parent, view, position, id ->
            toast("Click $position")
        }
    }
}