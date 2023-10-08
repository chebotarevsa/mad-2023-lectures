package ru.bsuedu.lec04.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bsuedu.lec04.listview.adapter.CustomArrayAdapter
import ru.bsuedu.lec04.listview.core.toast
import ru.bsuedu.lec04.listview.data.DataProvider
import ru.bsuedu.lec04.listview.databinding.ActivityCustomArrayAdapterBinding

class CustomArrayAdapter : AppCompatActivity() {
    private lateinit var binding: ActivityCustomArrayAdapterBinding
    private lateinit var customArrayAdapter: CustomArrayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomArrayAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customArrayAdapter = ru.bsuedu.lec04.listview.adapter.CustomArrayAdapter(
            this, R.layout.custom_array_adapter_item,
            R.id.text,
            R.id.delete_image,
            DataProvider.dataList
        )
        binding.lvListContainer.adapter = customArrayAdapter

        binding.fabAdd.setOnClickListener {
            customArrayAdapter.add(DataProvider.createNew())
        }

        binding.lvListContainer.setOnItemClickListener { parent, view, position, id ->
            toast("Click $position")
        }
    }
}