package com.sorrowblue.android.playground.compose

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sorrowblue.android.playground.compose.poke.PokeApi
import com.sorrowblue.android.playground.compose.poke.endpoint.Regions
import com.sorrowblue.android.playground.compose.poke.model.location.PokeRegion

class PokeRegionPagingSource(private val api: PokeApi) : PagingSource<Int, PokeRegion>() {

    override fun getRefreshKey(state: PagingState<Int, PokeRegion>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokeRegion> {
        val result = api.get(Regions(params.loadSize, params.key ?: 0))
        Log.d(
            "TAG", "key=${params.key}, next=${
                "offset=([0-9]+)".toRegex()
                    .find(result.next.toString())?.value?.toIntOrNull()
            }"
        )

        return LoadResult.Page(
            result.results,
            prevKey = null,
            nextKey = Regex("offset=([0-9]+)").find(result.next.toString())
                ?.groups?.get(1)?.value?.toIntOrNull()
        )
    }
}
