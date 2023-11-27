package ru.bsuedu.lec07.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<String>): List<User>

    @Query("SELECT * FROM user WHERE :name LIMIT 1")
    fun findByName(name: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}