package com.minjae.highthon.features.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.minjae.highthon.R
import com.minjae.highthon.core.component.BasicButton
import com.minjae.highthon.core.component.OmzTextField
import com.minjae.highthon.core.theme.Headline1
import com.minjae.highthon.core.theme.Headline2
import com.minjae.highthon.core.theme.OmzColor
import com.minjae.highthon.core.theme.Tag2

@Composable
fun LoginScreen(action: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = OmzColor.Gray20)
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(180.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(100.dp)
                .height(44.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Headline1(text = "로그인하기", modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(20.dp))

        var id by remember { mutableStateOf("") }
        OmzTextField(
            value = id,
            hint = "아이디를 입력하세요.",
            onValueChange = { id = it }
        )
        Spacer(modifier = Modifier.height(8.dp))

        var pw by remember { mutableStateOf("") }
        OmzTextField(
            value = pw,
            hint = "비밀번호를 입력하세요.",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            onValueChange = { pw = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        BasicButton(
            onClick = {
                if (id.isNotBlank() && pw.isNotBlank()) {
                    action()
                }
            },
            shape = RoundedCornerShape(8.dp),
            backgroundColor = if (id.isNotBlank() && pw.isNotBlank()) OmzColor.LightOrange else OmzColor.Gray40,
            pressedBackgroundColor = if (id.isNotBlank() && pw.isNotBlank()) OmzColor.MainColor else OmzColor.Gray40,
            disabledBackgroundColor = OmzColor.Gray40,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Headline2(
                text = "로그인",
                color = OmzColor.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Tag2(
            text = "회원이 아니시라면?",
            color = OmzColor.Gray80,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
