package com.minjae.highthon.features.myinfo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.minjae.highthon.R

@Composable
fun MyInfoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().offset(y = -24.dp),
            painter = painterResource(id = R.drawable.bg_my_page),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}