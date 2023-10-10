package ru.bsuedu.lab04.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.transform.CircleCropTransformation
import ru.bsuedu.lab04.recyclerview.R
import ru.bsuedu.lab04.recyclerview.data.User

class SimpleUserAdapter : RecyclerView.Adapter<SimpleUserAdapter.UserViewHolder>() {
    var users = emptyList<User>()
        set(users) {
            field = users
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.name.text = user.name
        holder.company.text = user.company

        holder.avatar.load(user.image) {
            placeholder(R.drawable.person)
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount(): Int =
        users.size


    class UserViewHolder(val v: View) : ViewHolder(v) {
        val name = v.findViewById<TextView>(R.id.tv_name)
        val company = v.findViewById<TextView>(R.id.tv_company)
        val avatar = v.findViewById<ImageView>(R.id.iv_avatar)
    }
}