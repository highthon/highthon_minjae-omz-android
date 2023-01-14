package com.minjae.highthon.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.minjae.highthon.core.theme.Headline1

@Composable
fun BasicOutLineButton(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    enabled: Boolean = true,
    onClick: () -> Unit,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
) {
}

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    enabled: Boolean = true,
    onClick: () -> Unit,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
    content: @Composable (isPressed: Boolean) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    val isPressed = interactionSource.collectIsPressedAsState()

    val btnColor =
        if (!enabled) disabledBackgroundColor else if (isPressed.value) pressedBackgroundColor else backgroundColor

    Box(
        modifier = modifier
            .background(
                color = btnColor,
                shape = shape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
                enabled = enabled
            ),
        contentAlignment = Alignment.Center
    ) {
        content(isPressed.value)
    }
}

@Composable
fun BasicBigButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    enabled: Boolean = true,
    onClick: () -> Unit,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
    textColor: Color,
    disabledTextColor: Color
) {
    val textColor = if (enabled) textColor else disabledTextColor

    BasicButton(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = shape,
        enabled = enabled,
        onClick = onClick,
        backgroundColor = backgroundColor,
        pressedBackgroundColor = pressedBackgroundColor,
        disabledBackgroundColor = disabledBackgroundColor,
    ) {
        Headline1(text = text, color = textColor)
    }
}

@Composable
fun BasicSmallButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    width: Dp = 152.dp,
    enabled: Boolean = true,
    onClick: () -> Unit,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
    textColor: Color,
    disabledTextColor: Color
) {
    val textColor = if (enabled) textColor else disabledTextColor

    BasicButton(
        modifier = modifier
            .width(width)
            .height(48.dp),
        shape = shape,
        enabled = enabled,
        onClick = onClick,
        backgroundColor = backgroundColor,
        pressedBackgroundColor = pressedBackgroundColor,
        disabledBackgroundColor = disabledBackgroundColor,
    ) {
        Headline1(text = text, color = textColor)
    }
}

@Composable
fun BasicRoundButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    enabled: Boolean = true,
    onClick: () -> Unit,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
    textColor: Color,
    disabledTextColor: Color,
    round: Dp
) {

    val shape = RoundedCornerShape(round)

    BasicBigButton(
        modifier = modifier,
        text = text,
        shape = shape,
        onClick = onClick,
        backgroundColor = backgroundColor,
        pressedBackgroundColor = pressedBackgroundColor,
        disabledBackgroundColor = disabledBackgroundColor,
        textColor = textColor,
        disabledTextColor = disabledTextColor,
        enabled = enabled
    )
}

@Composable
fun BasicIconButton(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    shape: Shape = CircleShape,
    backgroundColor: Color,
    pressedBackgroundColor: Color,
    disabledBackgroundColor: Color,
) {

    BasicButton(
        modifier = modifier.size(40.dp),
        shape = shape,
        enabled = enabled,
        onClick = onClick,
        backgroundColor = backgroundColor,
        pressedBackgroundColor = pressedBackgroundColor,
        disabledBackgroundColor = disabledBackgroundColor
    ) {
        Image(painter = painter, contentDescription = contentDescription)
    }
}
