package com.example.demoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoapp.dao.PageDao
import com.example.demoapp.models.Page

@Database(entities = [Page::class], version = 1)
abstract class PageDatabase : RoomDatabase() {

    abstract fun getPageDao(): PageDao

    companion object {
        @Volatile
        private var instance: PageDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, PageDatabase::class.java, "GroceryDatabase.db").build()
    }
}