package ru.bsuedu.lec06.lifecycle

fun main() {
    WeatherStation().apply {
        addObserver(LCDDisplay())
        addObserver(PrinterDisplay())
        val telegram = TelegramDisplay()
        addObserver(telegram)
        temperature = "-10.0"
        removeObserver(telegram)
        temperature = "-20.0"
    }
}


interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)

    fun notifyObserver ()
}

interface Observer {
  fun handleEvent(event:String)
}

class  WeatherStation: Observable {
    private val _observers: MutableList<Observer> = mutableListOf()

    var temperature: String = "0.0"
        set(value) {
            field = value
            notifyObserver()
        }
    override fun addObserver(observer: Observer) {
        _observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        _observers.remove(observer)
    }

    override fun notifyObserver() {
        _observers.forEach { it.handleEvent(temperature) }
    }
}

class  LCDDisplay: Observer {
    override fun handleEvent(event: String) {
        println("LCD $event")
    }

}

class  PrinterDisplay: Observer {
    override fun handleEvent(event: String) {
        println("Printer $event")
    }
}

class  TelegramDisplay: Observer {
    override fun handleEvent(event: String) {
        println("Telegram $event")
    }
}