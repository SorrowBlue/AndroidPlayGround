package com.sorrowblue.android.playground.compose.poke.endpoint

import com.sorrowblue.android.playground.compose.poke.model.game.Pokedex
import com.sorrowblue.android.playground.compose.poke.model.game.PokedexId
import io.ktor.resources.Resource

@Resource("pokedex")
class Pokedexes(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<Pokedex> {

    @Resource("{id}")
    class Id(val parent: Pokedexes = Pokedexes(), val id: PokedexId) :
        Endpoint<Pokedex>

    @Resource("{name}")
    class Name(val parent: Pokedexes = Pokedexes(), val name: String) :
        Endpoint<Pokedex>
}
