package com.example.demoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.sql.Date

@Entity(tableName = "page_table")
data class Page (
    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "image")
    var image:String,

    @ColumnInfo(name = "detail")
    var detail:String,

){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}