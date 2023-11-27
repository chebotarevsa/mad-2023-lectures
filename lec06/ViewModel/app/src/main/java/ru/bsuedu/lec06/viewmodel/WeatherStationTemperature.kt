package ru.bsuedu.lec06.viewmodel

import kotlin.random.Random

object WeatherStationTemperature {

    fun temperature() = Random.nextInt(-100, 100)
}