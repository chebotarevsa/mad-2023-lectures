package ru.bsuedu.lec04.listview.adapter

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import ru.bsuedu.lec04.listview.data.ItemData

class CustomArrayAdapter(
    context: Context,
    resource: Int,
    private val textViewResourceId: Int,
    private val imageViewResourceId: Int,
    objects: MutableList<ItemData>,
) : ArrayAdapter<ItemData>(context, resource, textViewResourceId, objects), View.OnClickListener {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)

        val textView = view.findViewById<TextView>(textViewResourceId)
        val imageView = view.findViewById<ImageView>(imageViewResourceId)

        getItem(position)?.let { item ->
            textView.text = item.name
            imageView.visibility = if (item.deletable) VISIBLE else GONE
            imageView.tag = position
            imageView.setOnClickListener(this)
        }
        return view
    }

    override fun onClick(v: View?) {
        v?.let {
            remove(getItem(v.tag as Int))
        }
    }
}