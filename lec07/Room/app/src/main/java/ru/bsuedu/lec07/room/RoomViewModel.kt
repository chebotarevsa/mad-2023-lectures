package ru.bsuedu.lec07.room

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import ru.bsuedu.lec07.room.data.User
import ru.bsuedu.lec07.room.data.UserDatabase
import kotlin.concurrent.thread

class RoomViewModel(private val db: UserDatabase) : ViewModel() {
    //val data = db.userDao().getAll()

    fun insertUser(name: String, surname: String) {
        viewModelScope.launch {
            db.userDao().insertAll(User(null, name, surname))
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val ctx =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return RoomViewModel(
                    db = UserDatabase.getInstance(ctx)
                ) as T
            }
        }
    }
}