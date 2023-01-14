package com.minjae.highthon.root

sealed class NavGroup(val group: String) {

    object OnBoarding : NavGroup("onBoarding") {
//        const val AUTH_HOME = "authHome"
    }

    object Home : NavGroup("home") {
        const val HOME = "HOME"
        const val HOME_DETAIL = "HOME_DETAIL"
        const val WRITE = "WRITE"
    }
}
