package ru.bsuedu.lab05.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bsuedu.lab05.fragment.data.User
import ru.bsuedu.lab05.fragment.databinding.ItemViewBinding

typealias  OnClick = (index: Int) -> Unit

class UserAdapter(val onClick: OnClick) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    var users: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return UserHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.binding.tvName.text = users[position].name
        holder.binding.tvSurname.text = users[position].surname
        holder.binding.root.setOnClickListener {
            onClick(position)
        }
    }

    class UserHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}