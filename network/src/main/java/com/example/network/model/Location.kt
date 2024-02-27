package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)