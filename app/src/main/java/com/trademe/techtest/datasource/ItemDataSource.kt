package com.trademe.techtest.datasource

import com.trademe.techtest.model.ItemDetails

interface ItemDataSource {
    suspend fun loadData(): List<ItemDetails>
}