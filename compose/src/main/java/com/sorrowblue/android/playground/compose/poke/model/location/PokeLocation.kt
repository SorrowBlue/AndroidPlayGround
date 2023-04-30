package com.sorrowblue.android.playground.compose.poke.model.location

import com.sorrowblue.android.playground.compose.poke.endpoint.Endpoint
import com.sorrowblue.android.playground.compose.poke.endpoint.Generations
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class PokeLocationId(val id: Int)

@Serializable
data class PokeGenerationGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val generation: PokeNamedAPIResource<Generations>
)

@Serializable
data class PokeLocation(
    val id: PokeLocationId,
    val name: String,
    val region: PokeNamedAPIResource<Endpoint<Unit>>,
    val names: List<PokeName>,
    @SerialName("game_indices")
    val game_indices: List<PokeGenerationGameIndex>,
    val areas: List<PokeNamedAPIResource<Endpoint<Unit>>>,
)
