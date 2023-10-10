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

class UsersDiffCallback(
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldList[oldItemPosition]
        val newUser = newList[newItemPosition]
        return oldUser == newUser
    }

}

class DiffUtilUserAdapter :
    RecyclerView.Adapter<DiffUtilUserAdapter.UserViewHolder>(),
    View.OnClickListener {

    private var onDeleteUser: OnDeleteUser = {}
    var users = emptyList<User>()
        set(users) {
            val diffCallback = UsersDiffCallback(field, users)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = users
            diffResult.dispatchUpdatesTo(this)
        }

    fun setOnDeleteUser(callback: OnDeleteUser) {
        onDeleteUser = callback
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

    override fun getItemCount(): Int = users.size

    class UserViewHolder(val binding: ModifyListItemBinding) : ViewHolder(binding.root)

    override fun onClick(v: View) {
        val user = v.tag as User
        onDeleteUser.invoke(user)
    }

}