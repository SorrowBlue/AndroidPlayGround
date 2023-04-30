package com.sorrowblue.android.playground.compose.poke.model.game

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import com.sorrowblue.android.playground.compose.poke.endpoint.VersionGroups
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class PokeGeneration(
    val id: PokeGenerationId,
    val name: String,
    val abilities: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val names: List<PokeName>,
    val main_region: PokeNamedAPIResource<Endpoint<Unit>>,
    val moves: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val pokemon_species: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val types: List<PokeNamedAPIResource<Endpoint<Unit>>>,
    val version_groups: List<PokeNamedAPIResource<VersionGroups>>
)
