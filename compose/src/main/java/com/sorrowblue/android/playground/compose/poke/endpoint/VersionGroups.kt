package com.sorrowblue.android.playground.compose.poke.endpoint

import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersionGroup
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersionGroupId
import io.ktor.resources.Resource

@Resource("version-group")
class VersionGroups(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<PokeVersionGroup> {

    @Resource("{id}")
    class Id(val parent: VersionGroups = VersionGroups(), val id: PokeVersionGroupId) :
        Endpoint<PokeVersionGroup>

    @Resource("{name}")
    class Name(val parent: VersionGroups = VersionGroups(), val name: String) :
        Endpoint<PokeVersionGroup>
}
