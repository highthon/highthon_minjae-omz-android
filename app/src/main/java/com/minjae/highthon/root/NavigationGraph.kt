package com.minjae.highthon.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minjae.highthon.features.chat.screen.ChatScreen
import com.minjae.highthon.features.home.screen.HomeDetailScreen
import com.minjae.highthon.features.home.screen.HomeScreen
import com.minjae.highthon.features.myinfo.screen.MyInfoScreen
import com.minjae.highthon.features.result.screen.ResultScreen
import com.minjae.highthon.features.write.screen.WriteScreen
import com.minjae.highthon.utils.BottomNavItem

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Result.screenRoute) {
            ResultScreen()
        }
        composable(BottomNavItem.Chat.screenRoute) {
            ChatScreen()
        }
        composable(BottomNavItem.MyInfo.screenRoute) {
            MyInfoScreen()
        }
        
        composable(NavGroup.Home.HOME_DETAIL) {
            HomeDetailScreen(navController = navController)
        }

        composable(NavGroup.Home.WRITE) {
            WriteScreen(navController = navController)
        }
    }
}