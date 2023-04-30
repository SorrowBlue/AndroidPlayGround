package com.sorrowblue.android.playground.compose.poke.model.game

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import com.sorrowblue.android.playground.compose.poke.endpoint.Generations
import com.sorrowblue.android.playground.compose.poke.endpoint.Pokedexes
import com.sorrowblue.android.playground.compose.poke.endpoint.Version
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokeVersionGroup(
    val id: PokeVersionGroupId,
    val name: String,
    val order: Int,
    val generation: PokeNamedAPIResource<Generations>,
    @SerialName("move_learn_methods")
    val move_learn_methods: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val pokedexes: List<PokeNamedAPIResource<Pokedexes>>,
    val regions: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val versions: List<PokeNamedAPIResource<Version>>
)
