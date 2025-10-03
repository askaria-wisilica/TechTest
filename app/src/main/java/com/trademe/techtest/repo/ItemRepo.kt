package com.trademe.techtest.repo

import com.trademe.techtest.datasource.ItemDataSource

class ItemRepo(private val itemDataSource: ItemDataSource) {
    suspend fun readData() = itemDataSource.loadData().take(20)
}