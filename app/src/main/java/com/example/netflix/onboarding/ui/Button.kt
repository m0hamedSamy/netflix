package com.example.netflix.onboarding.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix.R

@Composable
fun DefaultTextBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = colorResource(id = R.color.default_btn_background),
    text: String,
    fontSize: TextUnit = 18.sp,
    textColor: Color = colorResource(id = R.color.default_text),
    textFont: Font = Font(R.font.plus_jakarta_sans_medium),
    textAlign: TextAlign = TextAlign.Center,
    padding: Dp = 0.dp,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = backgroundColor
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = textColor,
            fontFamily = textFont.toFontFamily(),
            textAlign = textAlign,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun TransparentTextBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    fontSize: TextUnit = 18.sp,
    textColor: Color = colorResource(id = R.color.default_text),
    textFont: Font = Font(R.font.plus_jakarta_sans_medium),
    textAlign: TextAlign = TextAlign.Center,
    padding: Dp = 0.dp,
    enabled: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            disabledBackgroundColor = Color.Transparent
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = textColor,
            fontFamily = textFont.toFontFamily(),
            textAlign = textAlign,
            modifier = Modifier.padding(padding)
        )
    }
}