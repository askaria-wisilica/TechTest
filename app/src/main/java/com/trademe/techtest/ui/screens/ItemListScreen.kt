package com.trademe.techtest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trademe.techtest.datasource.ItemDataSourceImpl
import com.trademe.techtest.repo.ItemRepo
import com.trademe.techtest.ui.state.ItemScreenStatus
import com.trademe.techtest.viewmodel.ItemViewModel
import com.trademe.techtest.viewmodel.ItemVmFactory

@Composable
fun ItemListScreen() {
    val context = LocalContext.current
    val itemRepo = ItemRepo(ItemDataSourceImpl(context))
    val itemViewModel: ItemViewModel = viewModel(factory = ItemVmFactory(itemRepo))
    val uiState by itemViewModel.state
    when (uiState.status) {
        ItemScreenStatus.SUCCESS -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                itemsIndexed(uiState.itemList) { index, item ->
                    ItemCardView(item)

                    // Divider after each item except last
                    if (index < uiState.itemList.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            thickness = 1.dp,
                            color = Color.LightGray.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }

        ItemScreenStatus.ONGOING -> {

        }
    }
}