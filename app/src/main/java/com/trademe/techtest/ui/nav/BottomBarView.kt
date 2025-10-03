package com.trademe.techtest.ui.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.trademe.techtest.model.BottomNavItem
import com.trademe.techtest.R
import com.trademe.techtest.ui.theme.Tasman500
import com.trademe.techtest.ui.theme.TextLight

@Composable
fun BottomBarView(navController: NavHostController, onItemClick: (item: BottomNavItem)-> Unit) {
    val currentSelected = navController.currentBackStackEntryAsState().value?.destination
    NavigationBar(containerColor = Color.White) {
        bottomNavigationItems().forEach { item ->
            NavigationBarItem(
                selected = currentSelected?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                    onItemClick(item)
                },
                label = { Text(item.label) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "item",
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Tasman500,
                    selectedTextColor = Tasman500,
                    unselectedIconColor = TextLight,
                    unselectedTextColor = TextLight,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun bottomNavigationItems() : List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            label = stringResource(R.string.discover),
            icon = R.drawable.search,
            route = ScreenRoute.DISCOVER
        ),
        BottomNavItem(
            label = stringResource(R.string.watchlist),
            icon = R.drawable.ic_binoculars,
            route = ScreenRoute.WATCHLIST
        ),
        BottomNavItem(
            label =stringResource(R.string.profile),
            icon = R.drawable.profile,
            route = ScreenRoute.PROFILE
        ),
    )
}