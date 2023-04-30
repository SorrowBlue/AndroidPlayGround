package com.sorrowblue.android.playground.compose.poke.model.location

import com.sorrowblue.android.playground.compose.poke.endpoint.Generations
import com.sorrowblue.android.playground.compose.poke.endpoint.Locations
import com.sorrowblue.android.playground.compose.poke.endpoint.Pokedexes
import com.sorrowblue.android.playground.compose.poke.endpoint.VersionGroups
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class PokeRegionId(val id: Int)

@Serializable
data class PokeRegion(
    val id: PokeRegionId,
    val locations: List<PokeNamedAPIResource<Locations>>,
    val name: String,
    val names: List<PokeName>,
    @SerialName("main_generation")
    val mainGeneration: PokeNamedAPIResource<Generations>?,
    val pokedexes: List<PokeNamedAPIResource<Pokedexes>>,
    @SerialName("version_groups")
    val versionGroups: List<PokeNamedAPIResource<VersionGroups>>
)
