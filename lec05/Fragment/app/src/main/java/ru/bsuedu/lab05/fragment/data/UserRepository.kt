package ru.bsuedu.lab05.fragment.data

object UserRepository {
    val  users = (0..100).map {
        User("Name $it", "Surname $it")
    }.toMutableList()
}