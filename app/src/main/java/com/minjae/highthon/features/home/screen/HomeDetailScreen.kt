package com.minjae.highthon.features.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.minjae.highthon.R
import com.minjae.highthon.core.modifier.omzClickable
import com.minjae.highthon.core.theme.Headline1
import com.minjae.highthon.core.theme.OmzColor

@Composable
fun HomeDetailScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp,
                ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .omzClickable {
                        navController.popBackStack()
                    }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Headline1(text = "게시글 등록")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.bg_home_detail),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(OmzColor.DIVIDER))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.fake_home_detail_comment),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeDetailScreen() {
    HomeDetailScreen(rememberNavController())
}