package com.example.demoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.demoapp.database.PageRepository
import com.example.demoapp.models.Page
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PageViewModel(private val repository: PageRepository) : ViewModel() {

    fun insert(item: Page) = GlobalScope.launch {
        repository.insert(item)
    }

    @DelicateCoroutinesApi
    fun delete(item: Page) = GlobalScope.launch {
        repository.delete(item)
    }

    fun allPageItems() = repository.allPagesItems()

}