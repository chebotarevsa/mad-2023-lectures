package ru.bsuedu.lec07.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao


    companion object {
        private var db: UserDatabase? = null
        fun getInstance(ctx: Context): UserDatabase {
            synchronized(this) {
                var instance = db
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        ctx,
                        UserDatabase::class.java, "database-name"
                    ).build()
                    db = instance
                }
                return instance
            }

        }

    }
}
