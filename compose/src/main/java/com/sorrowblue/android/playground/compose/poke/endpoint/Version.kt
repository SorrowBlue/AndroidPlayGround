package com.sorrowblue.android.playground.compose.poke.endpoint

import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersion
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersionId
import io.ktor.resources.Resource

@Resource("version")
class Version(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<PokeVersion> {

    @Resource("{id}")
    class Id(val parent: Version = Version(), val id: PokeVersionId) :
        Endpoint<PokeVersion>

    @Resource("{name}")
    class Name(val parent: Version = Version(), val name: String) :
        Endpoint<PokeVersion>
}
