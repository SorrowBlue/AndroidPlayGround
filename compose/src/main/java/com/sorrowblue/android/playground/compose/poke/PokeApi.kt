package com.sorrowblue.android.playground.compose.poke

import android.content.Context
import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import com.sorrowblue.android.playground.compose.poke.endpoint.PagingEndpoint
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResourceList
import com.sorrowblue.android.playground.compose.poke.model.common.PokePagination
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.plugins.resources.get
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import java.nio.file.Files

class PokeApi(context: Context) {
    val client = HttpClient(Android) {

        install(Resources)
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            level = LogLevel.BODY
            logger = Logger.Companion.ANDROID
        }
        install(HttpCache) {
            val path = context.cacheDir.toPath().resolve("http_cache")
            publicStorage(FileStorage(Files.createDirectories(path).toFile()))
        }
        defaultRequest {
            url("https://pokeapi.co/api/v2/")
        }
    }

    suspend inline fun <reified T : Any, reified V : PagingEndpoint<T>> get(pokeResourceLists: V): PokePagination<T> {
        return client.get(pokeResourceLists).body<PokeNamedAPIResourceList>()
            .pagination { client.get(it.url).body() }
    }

    suspend inline fun <reified T : Any, reified V : Endpoint<T>> get(pokeResource: V): T {
        return client.get(pokeResource).body()
    }
}
