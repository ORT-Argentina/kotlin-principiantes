package com.ort.roomdatabaseexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ort.roomdatabaseexample.entities.User


@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class appDatabase : RoomDatabase() {

    abstract fun userDao(): userDao

    companion object {

        var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "userDB"
                    ).addMigrations().allowMainThreadQueries().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}