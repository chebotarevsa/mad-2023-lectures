package ru.bsuedu.lec08.network.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.bsuedu.lec08.network.data.okhttp.OkHttpDataSource
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response:LiveData<String> = _response;


    fun  call() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = OkHttpDataSource.coroutineGetRequest();
            withContext(Dispatchers.Main){
                _response.value = res
            }
        }
    }

}