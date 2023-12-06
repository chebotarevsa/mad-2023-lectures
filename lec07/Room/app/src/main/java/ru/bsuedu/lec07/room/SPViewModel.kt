package ru.bsuedu.lec07.room

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.bsuedu.lec07.room.data.User
import ru.bsuedu.lec07.room.data.UserDatabase

class SPViewModel(application: Application) : AndroidViewModel(application) {

    fun insertUser(name:String, surname:String) {
        val application = getApplication<Application>();
        val sp  =  application.getSharedPreferences("user", Context.MODE_PRIVATE)

        with(sp.edit()){
            putString( getApplication<Application>().getString(R.string.name), name)
            putString( getApplication<Application>().getString(R.string.surname),surname)
            apply()
        }
    }

}