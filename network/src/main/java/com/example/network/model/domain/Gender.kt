package com.example.network.model.domain

sealed class Gender(val displayName: String) {
    object Male: Gender("Male")
    object Female: Gender("Female")
    object Genderless: Gender("Genderless")
    object Unknown: Gender("Not specified")
}