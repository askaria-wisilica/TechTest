package com.trademe.techtest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trademe.techtest.repo.ItemRepo

class ItemVmFactory(private val repo: ItemRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            return ItemViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown VM")
    }
}