package com.sorrowblue.android.playground.compose.poke.model.game

import com.sorrowblue.android.playground.compose.poke.endpoint.Generations
import com.sorrowblue.android.playground.compose.poke.endpoint.VersionGroups
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.poke.model.common.PokeNamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokeVersion(
    val id: PokeVersionId,
    val name: String,
    val names: List<PokeName>,
    @SerialName("version_group")
    val versionGroup: PokeNamedAPIResource<VersionGroups>
)

val PokeNamedAPIResource<VersionGroups>.resource get() = VersionGroups.Name(name = name)

val PokeNamedAPIResource<Generations>.resource get() = Generations.Name(name = name)
