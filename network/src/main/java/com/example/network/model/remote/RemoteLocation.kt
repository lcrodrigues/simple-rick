package com.example.network.model.remote

import com.example.network.model.domain.Location
import kotlinx.serialization.Serializable

@Serializable
data class RemoteLocation(
    val name: String,
    val url: String
)

fun RemoteLocation.toDomainLocation(): Location {
    return Location(
        name = name,
        url = url
    )
}