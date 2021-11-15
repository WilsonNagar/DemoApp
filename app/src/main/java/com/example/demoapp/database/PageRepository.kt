package com.example.demoapp.database

import com.example.demoapp.models.Page

class PageRepository(private val db: PageDatabase) {
    suspend fun insert(item: Page) = db.getPageDao().insert(item)
    suspend fun delete(item: Page) = db.getPageDao().delete(item)

    fun allPagesItems() = db.getPageDao().getPages()
}