package ru.sulatskov.composeapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class JetTypography internal constructor(
        val paragraph1: TextStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
        ),
        val textSmallLight: TextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 20.sp
        ),
        val textSmall: TextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
        ),
        val textSmallBold: TextStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp
        ),
        val textMedium: TextStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
        ),
        val textMediumLight: TextStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 20.sp
        ),
        val materialTypography: Typography = Typography(
                body1 = paragraph1
        )
)