package com.example.network.model.domain

import androidx.compose.ui.graphics.Color

sealed class Status(val displayName: String, val color: Color) {
    object Alive: Status("Alive", Color.Green)
    object Dead: Status("Dead", Color.Red)
    object Unknown: Status("Unknown", Color.Yellow)
}