package com.example.network.model.domain

data class Character(
    val created: String,
    val episodes: List<String>,
    val gender: Gender,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: Status,
    val type: String,
    val url: String
)