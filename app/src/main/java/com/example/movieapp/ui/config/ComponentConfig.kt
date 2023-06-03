package com.example.movieapp.ui.config

import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import com.example.movieapp.ui.theme.color.ColorSet

data class ComponentConfig(
    val colors: ColorSet,
    val typography: Typography,
    val shapes: Shapes,
    val isDarkTheme: Boolean
)