package com.minjae.highthon.root

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.minjae.highthon.features.home.screen.HomeDetailScreen
import com.minjae.highthon.features.home.screen.HomeScreen

fun NavGraphBuilder.boardNavigation(
    navController: NavController
) {
    navigation(
        startDestination = NavGroup.Home.HOME,
        route = NavGroup.Home.group,
    ) {

        composable(NavGroup.Home.HOME) {
            HomeScreen(navController = navController)
        }

        composable(NavGroup.Home.HOME_DETAIL) {
            HomeDetailScreen(navController = navController)
        }

    }
}
