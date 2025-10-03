package com.trademe.techtest.ui.state

import com.trademe.techtest.model.ItemDetails

data class ItemScreenState(
    var status: Int = ItemScreenStatus.IDLE,
    var itemList: MutableList<ItemDetails> = mutableListOf()
)


object ItemScreenStatus{
    const val IDLE = -1
    const val ONGOING = 0
    const val SUCCESS = 1
}