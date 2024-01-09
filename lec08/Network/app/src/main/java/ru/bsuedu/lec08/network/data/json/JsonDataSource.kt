package ru.bsuedu.lec08.network.data.json

import com.google.gson.Gson


data class User(val name:String, val surname:String)


object JsonDataSource {
    private val gson = Gson()
    fun simpleToJson(){
        val ints = intArrayOf(1, 2, 3, 4, 5) // -> [1,2,3,...]
        val strings = arrayOf("abc", "def", "ghi") // -> ["abc", "def", "ghi"]
        val map = mapOf("one" to  1, "two" to 2) // -> {"one": 1, "two": 2}
        val user = User("Ivan", "Ivanov") //-> {"name": "Ivan", "surname": "Ivanov" }


        println(gson.toJson(ints))
        println(gson.toJson(strings))
        println(gson.toJson(map))
        println(gson.toJson(user))
    }

    fun simpleFromJson(){
        val userString = "{\"name\":\"Ivan\",\"surname\":\"Ivanov\"}"
        val user = gson.fromJson(userString,User::class.java)
        println(user)
    }
}

fun main() {
   // JsonDataSource.simpleToJson()
   JsonDataSource.simpleFromJson()
}