package com.sorrowblue.android.playground.compose.poke.model.game

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class PokemonEntry(
    val entry_number: Int,
    val pokemon_species: PokeNamedAPIResource<Endpoint<Unit>>
)
