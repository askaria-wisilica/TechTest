package com.trademe.techtest.datasource

import android.content.Context
import com.trademe.techtest.model.ItemDetails
import com.trademe.techtest.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemDataSourceImpl(private val context: Context): ItemDataSource {
    override suspend fun loadData(): List<ItemDetails> {
        val content = context.resources.openRawResource(R.raw.item_details)
            .bufferedReader()
            .use { it.readText() }
        val gson = Gson()
        val items: List<ItemDetails> = gson.fromJson(
            content, object : TypeToken<List<ItemDetails>>() {}.type
        )
        return items
    }
}