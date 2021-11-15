package com.example.demoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demoapp.models.Page

@Dao
interface PageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Page)

    @Delete
    suspend fun delete(item : Page)

    @Query("SELECT * FROM page_table")
    fun getPages(): LiveData<List<Page>>
}