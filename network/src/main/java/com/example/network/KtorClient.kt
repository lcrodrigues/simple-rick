package com.example.network

import com.example.network.model.domain.Character
import com.example.network.model.remote.RemoteCharacter
import com.example.network.model.remote.toDomainCharacter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private val baseUrl = "https://rickandmortyapi.com/api/"

    private val client = HttpClient(OkHttp) {
        defaultRequest { url(baseUrl) }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys =
                    true // ignore entries that are not defined in the serializable data class
            })
        }
    }

    suspend fun getCharacter(id: Int): Character {
        return client
            .get("character/$id")
            .body<RemoteCharacter>()
            .toDomainCharacter()
    }
}