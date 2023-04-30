package com.sorrowblue.android.playground.compose.poke.model.game

import com.sorrowblue.android.playground.compose.poke.endpoint.Regions
import com.sorrowblue.android.playground.compose.poke.endpoint.VersionGroups
import com.sorrowblue.android.playground.compose.poke.model.common.PokeDescription
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    val id: PokedexId,
    val name: String,
    @SerialName("is_main_series")
    val isMainSeries: Boolean,
    val descriptions: List<PokeDescription>,
    val names: List<PokeName>,
    @SerialName("pokemon_entries")
    val pokemonEntries: List<PokemonEntry>,
    val region: List<PokeNamedAPIResource<Regions>>,
    @SerialName("version_groups")
    val versionGroups: List<PokeNamedAPIResource<VersionGroups>>
)
