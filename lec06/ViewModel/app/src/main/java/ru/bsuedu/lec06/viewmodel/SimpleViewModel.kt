package ru.bsuedu.lec06.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlin.random.Random

typealias Observer = (Int)->Unit

class SimpleViewModel(val repo: WeatherStationTemperature) : ViewModel() {
    private var _weatherStationTemperature: Int = 0
    private var _weatherStationObserver: Observer? = null

    fun setObserverWeatherStation(observer:Observer) {
        _weatherStationObserver = observer
    }

    fun update() {
        _weatherStationTemperature =  repo.temperature()
        _weatherStationObserver?.invoke(_weatherStationTemperature)
    }

    init {
        Log.i("SimpleViewModel", "Init")
    }

    override fun onCleared() {
        Log.i("SimpleViewModel", "onCleared")
        super.onCleared()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val ctx = checkNotNull(extras[APPLICATION_KEY])
                return SimpleViewModel(
                    repo = WeatherStationTemperature
                ) as T
            }
        }
    }

}