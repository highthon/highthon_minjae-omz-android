package com.minjae.highthon.utils

import com.minjae.highthon.R

sealed class BottomNavItem(
    val title: Int, val icon: Int, val screenRoute: String
) {
    object Home : BottomNavItem(R.string.text_home, R.drawable.ic_home, HOME)
    object Result : BottomNavItem(R.string.text_result, R.drawable.ic_article, RESULT)
    object Chat : BottomNavItem(R.string.text_chat, R.drawable.ic_comment, CHAT)
    object MyInfo : BottomNavItem(R.string.text_myinfo, R.drawable.ic_orange_user, MYINFO)
}