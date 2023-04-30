package com.sorrowblue.android.playground.compose.poke.model.common

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import kotlinx.serialization.Serializable

@Serializable
data class PokeName(val name: String, val language: PokeNamedAPIResource<Endpoint<Unit>>)
