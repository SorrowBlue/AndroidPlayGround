package com.sorrowblue.android.playground.compose.poke.model.common

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import kotlinx.serialization.Serializable

@Serializable
data class PokeNamedAPIResourceList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokeNamedAPIResource<Endpoint<Unit>>>
) {
    inline fun <T> pagination(action: (PokeNamedAPIResource<Endpoint<Unit>>) -> T) =
        PokePagination(count, next, previous, results.map { action.invoke(it) })
}
