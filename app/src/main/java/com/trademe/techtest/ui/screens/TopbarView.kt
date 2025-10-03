package com.trademe.techtest.ui.screens

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.trademe.techtest.R
import com.trademe.techtest.ui.theme.Tasman500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarView(navigationSelectedItem: String) {
    val context = LocalContext.current
    TopAppBar(title = { Text(navigationSelectedItem) }, actions = {
        IconButton(onClick = {
            Toast.makeText(
                context,
                context.getString(R.string.msg_search_click),
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
                tint = Tasman500
            )
        }
        IconButton(onClick = {
            Toast.makeText(context, context.getString(R.string.cart_click), Toast.LENGTH_SHORT)
                .show()

        }) {
            Icon(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart",
                tint = Tasman500
            )
        }
    }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White))
}