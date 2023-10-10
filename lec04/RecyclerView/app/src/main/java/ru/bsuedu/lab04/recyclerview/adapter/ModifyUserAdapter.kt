package ru.bsuedu.lab04.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.transform.CircleCropTransformation
import ru.bsuedu.lab04.recyclerview.R
import ru.bsuedu.lab04.recyclerview.data.User
import ru.bsuedu.lab04.recyclerview.data.UserRepository
import ru.bsuedu.lab04.recyclerview.databinding.ModifyListItemBinding

typealias OnDeleteUser = (User) -> Unit


class ModifyUserAdapter() :
    RecyclerView.Adapter<ModifyUserAdapter.UserViewHolder>(),
    View.OnClickListener {
    
    private var onDeleteUser: OnDeleteUser = {}

    fun setOnDeleteUser(callback: OnDeleteUser) {
        onDeleteUser = callback
    }

    var users = emptyList<User>()
        set(users) {
            field = users
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ModifyListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        with(holder.binding) {
            tvName.text = user.name
            tvCompany.text = user.company
            ivAvatar.load(user.image) {
                placeholder(R.drawable.person)
                transformations(CircleCropTransformation())
            }
            ivDelete.tag = user
            ivDelete.setOnClickListener(::onClick)
        }
    }

    override fun onClick(v: View) {
        val user = v.tag as User
        onDeleteUser.invoke(user)
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(val binding: ModifyListItemBinding) : ViewHolder(binding.root)

}