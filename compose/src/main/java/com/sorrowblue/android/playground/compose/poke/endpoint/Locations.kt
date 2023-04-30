package com.sorrowblue.android.playground.compose.poke.endpoint

import com.sorrowblue.android.playground.compose.poke.model.location.PokeLocation
import com.sorrowblue.android.playground.compose.poke.model.location.PokeLocationId
import com.sorrowblue.android.playground.compose.poke.model.location.PokeRegion
import com.sorrowblue.android.playground.compose.poke.model.location.PokeRegionId
import io.ktor.resources.Resource

@Resource("location")
class Locations(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<PokeLocation> {

    @Resource("{id}")
    class Id(val parent: Locations = Locations(), val id: PokeLocationId) :
        Endpoint<PokeLocation>

    @Resource("{name}")
    class Name(val parent: Locations = Locations(), val name: String) :
        Endpoint<PokeLocation>
}

@Resource("region")
class Regions(override val limit: Int = 20, override val offset: Int = 0) :
    PagingEndpoint<PokeRegion> {

    @Resource("{id}")
    class Id(val parent: Regions = Regions(), val id: PokeRegionId) :
        Endpoint<PokeRegion>

    @Resource("{name}")
    class Name(val parent: Regions = Regions(), val name: String) :
        Endpoint<PokeRegion>
}
