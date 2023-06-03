package com.example.movieapp.ui.config

import com.example.movieapp.ui.theme.Shapes
import com.example.movieapp.ui.theme.Typography
import com.example.movieapp.ui.theme.color.ColorSet

object DefaultComponentConfig {
    val RED_THEME = ComponentConfig(
        colors = ColorSet.Red,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    val BLUE_THEME = ComponentConfig(
        colors = ColorSet.Blue,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    private var currentConfig = RED_THEME
    private var themeColorSet: ColorSet = ColorSet.Red
}