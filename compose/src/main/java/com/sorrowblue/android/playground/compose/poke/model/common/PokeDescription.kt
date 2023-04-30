package com.sorrowblue.android.playground.compose.poke.model.common

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import kotlinx.serialization.Serializable

@Serializable
data class PokeDescription(
    val description: String,
    val lambda: PokeNamedAPIResource<Endpoint<Unit>>
)
