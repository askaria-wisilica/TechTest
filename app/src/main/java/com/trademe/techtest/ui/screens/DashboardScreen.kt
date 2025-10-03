package com.trademe.techtest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.trademe.techtest.R
import com.trademe.techtest.ui.nav.BottomBarView
import com.trademe.techtest.ui.nav.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var navigationSelectedItem by remember {
        mutableStateOf(context.getString(R.string.discover))
    }
    Scaffold(
        topBar = { TopbarView(navigationSelectedItem) },
        bottomBar = {
            BottomBarView(navController, onItemClick = {
                navigationSelectedItem = it.label
            })
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = ScreenRoute.DISCOVER,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(ScreenRoute.DISCOVER) { ItemListScreen() }
            composable(ScreenRoute.WATCHLIST) { DummyScreen(stringResource(R.string.watchlist)) }
            composable(ScreenRoute.PROFILE) { DummyScreen(stringResource(R.string.profile)) }
        }
    }
}