package com.example.network.model.remote

import com.example.network.model.domain.Character
import com.example.network.model.domain.Gender
import com.example.network.model.domain.Status
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: RemoteLocation,
    val name: String,
    val origin: RemoteOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
fun RemoteCharacter.toDomainCharacter(): Character {
    val characterGender = when (gender.lowercase()) {
        "male" -> Gender.Male
        "female" -> Gender.Female
        "genderless" -> Gender.Genderless
        else -> Gender.Unknown
    }

    val characterStatus = when (status.lowercase()) {
        "alive" -> Status.Alive
        "dead" -> Status.Dead
        else -> Status.Unknown
    }

    return Character(
        created = created,
        episodes = episode,
        gender = characterGender,
        id = id,
        image = image,
        location = location.toDomainLocation(),
        name = name,
        origin = origin.toDomainOrigin(),
        species = species,
        status = characterStatus,
        type = type,
        url = url
    )
}