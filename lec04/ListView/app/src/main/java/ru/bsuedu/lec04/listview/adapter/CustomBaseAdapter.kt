package ru.bsuedu.lec04.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import ru.bsuedu.lec04.listview.data.ItemData
import ru.bsuedu.lec04.listview.databinding.BaseArrayAdapterItemBinding
import ru.bsuedu.lec04.listview.databinding.SimpleAdapterItemBinding

typealias  OnDelete = (ItemData) -> Unit

class CustomBaseAdapter(
    private val context: Context,
    private val objects: List<ItemData>,
    private val onDelete: OnDelete
) : BaseAdapter(), View.OnClickListener {
    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(position: Int): Any {
        return objects[position]
    }

    override fun getItemId(position: Int): Long {
        return objects[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemBinding = convertView?.let { BaseArrayAdapterItemBinding.bind(it) }
            ?: BaseArrayAdapterItemBinding.inflate(LayoutInflater.from(context), parent, false)

        (getItem(position) as ItemData)
            .apply {
                itemBinding.textId.text = id.toString()
                itemBinding.textName.text = name
                itemBinding.textId.setTextColor(color)
                itemBinding.deleteImage.visibility = if (deletable) View.VISIBLE else View.GONE
                itemBinding.deleteImage.tag = position
            }
            .also {
                itemBinding.deleteImage.setOnClickListener(this)
            }

        return itemBinding.root
    }

    override fun onClick(v: View?) {
        val position = v?.tag as Int?
        position?.let {
            onDelete(getItem(position) as ItemData)
        }
    }
}