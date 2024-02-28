package com.example.network.model.remote

import com.example.network.model.domain.Origin
import kotlinx.serialization.Serializable

@Serializable
data class RemoteOrigin(
    val name: String,
    val url: String
)

fun RemoteOrigin.toDomainOrigin(): Origin {
    return Origin(
        name = name,
        url = url
    )
}