package ru.bsuedu.lec06.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import kotlin.concurrent.thread

class MyViewModel : ViewModel() {
    private val _weatherStationTemperature = MutableLiveData<Int>()
    public val weatherStationTemperature: LiveData<Int> = _weatherStationTemperature

    public val weatherStationAsString: LiveData<String> = _weatherStationTemperature.map { it.toString() }

    private val _weatherStation2 = MutableLiveData<Int>()
    public val weatherStation2: LiveData<Int> = _weatherStation2
//
    private val _allWeatherStation = MediatorLiveData<Int>()
//
    public val allWeatherStationAsString: LiveData<String> =
        _allWeatherStation.map { it.toString() }

    init {
        _weatherStationTemperature.value = 0
        _weatherStation2.value = 0

        _allWeatherStation.addSource(_weatherStationTemperature) {
            _allWeatherStation.value = it
        }
        _allWeatherStation.addSource(_weatherStation2) {
            _allWeatherStation.value = it
        }
    }

    fun updateTemperature() {
        thread {
            Thread.sleep(1000)
            _weatherStationTemperature.postValue(100)
        }

        thread {
            Thread.sleep(2000)
            _weatherStation2.postValue(400)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}