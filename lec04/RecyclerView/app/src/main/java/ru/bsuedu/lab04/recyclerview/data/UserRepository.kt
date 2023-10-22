package ru.bsuedu.lab04.recyclerview.data

import com.github.javafaker.Faker


object UserRepository {
    private val faker = Faker()
    private val _users = (1..20000).map {
        User(
            id = it.toLong(),
            name = faker.name().firstName(),
            company = faker.company().name(),
            image = "https://randomuser.me/api/portraits/women/$it.jpg"
        )
    }.toMutableList()

    val users
        get() = _users.toList()

    public fun add() {
        _users.add(createNew(_users.size + 1))
    }

    public fun remove(user: User) {
        _users.remove(user)
    }


    private fun createNew(id: Int): User = User(
        id = id.toLong(),
        name = faker.name().firstName(),
        company = faker.company().name(),
        image = "https://randomuser.me/api/portraits/women/$id.jpg"
    )


}