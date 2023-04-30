package com.sorrowblue.android.playground.compose.poke.endpoint

import com.sorrowblue.android.playground.compose.poke.model.game.PokeGeneration
import com.sorrowblue.android.playground.compose.poke.model.game.PokeGenerationId
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersionGroup
import io.ktor.resources.Resource

@Resource("generation")
class Generations(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<PokeGeneration> {

    @Resource("{id}")
    class Id(val parent: Generations = Generations(), val id: PokeGenerationId) :
        Endpoint<PokeVersionGroup>

    @Resource("{name}")
    class Name(val parent: Generations = Generations(), val name: String) :
        Endpoint<PokeVersionGroup>
}

