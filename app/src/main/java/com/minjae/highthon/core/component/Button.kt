package com.minjae.highthon.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.minjae.highthon.core.icon.OmzIcon
import com.minjae.highthon.core.theme.Headline1
import com.minjae.highthon.core.theme.OmzColor

@Composable
fun BigMainRoundButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BasicRoundButton(
        round = round,
        modifier = modifier,
        text = text,
        shape = RoundedCornerShape(round),
        onClick = onClick,
        backgroundColor = OmzColor.MainColor,
        pressedBackgroundColor = OmzColor.PressedColor,
        disabledBackgroundColor = OmzColor.SubColor,
        textColor = OmzColor.White,
        disabledTextColor = OmzColor.White,
        enabled = enabled
    )
}

@Composable
fun BigSmallRoundButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BasicSmallButton(
        modifier = modifier,
        text = text,
        shape = RoundedCornerShape(round),
        onClick = onClick,
        backgroundColor = OmzColor.MainColor,
        pressedBackgroundColor = OmzColor.PressedColor,
        disabledBackgroundColor = OmzColor.SubColor,
        textColor = OmzColor.White,
        disabledTextColor = OmzColor.White,
        enabled = enabled
    )
}

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    round: Dp = 16.dp,
    text: String,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(round),
        enabled = enabled
    ) {
        Headline1(text = text, color = textColor)
    }
}

//@Composable
//fun PlusButton(
//    modifier: Modifier = Modifier,
//    painter: Painter = painterResource(id = OmzIcon.Plus),
//    contentDescription: String?,
//    enabled: Boolean = true,
//    onClick: () -> Unit
//) {
//    BasicIconButton(
//        modifier = modifier,
//        painter = painter,
//        contentDescription = contentDescription,
//        onClick = onClick,
//        backgroundColor = OmzColor.MainColor,
//        pressedBackgroundColor = OmzColor.PressedColor,
//        disabledBackgroundColor = OmzColor.SubColor,
//        enabled = enabled
//    )
//}

@Preview
@Composable
fun ButtonPreview() {
    Column(modifier = Modifier.background(OmzColor.Gray100)) {
        BigMainRoundButton(text = "로그인") {
        }

        BigSmallRoundButton(text = "로그인") {
        }

        OutlineButton(text = "123") {
        }
    }
}
