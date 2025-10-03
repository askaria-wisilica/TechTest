package com.trademe.techtest.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trademe.techtest.model.ItemDetails
import com.trademe.techtest.repo.ItemRepo
import com.trademe.techtest.ui.state.ItemScreenState
import com.trademe.techtest.ui.state.ItemScreenStatus
import kotlinx.coroutines.launch

class ItemViewModel(private val itemRepo: ItemRepo): ViewModel() {
    private var _state = mutableStateOf(ItemScreenState())
    val state: State<ItemScreenState> = _state

    init {
        readData()
    }

    fun readData() {
        _state.value = ItemScreenState(status = ItemScreenStatus.ONGOING)
        viewModelScope.launch {
            val data = itemRepo.readData()
            _state.value = ItemScreenState(
                status = ItemScreenStatus.SUCCESS,
                itemList = data as MutableList<ItemDetails>
            )
        }
    }
}