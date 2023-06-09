package com.sorrowblue.android.playground.compose

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sorrowblue.android.playground.compose.poke.PokeApi
import com.sorrowblue.android.playground.compose.poke.endpoint.Version
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersion

class PokeVersionPagingSource(private val api: PokeApi) : PagingSource<Int, PokeVersion>() {

    override fun getRefreshKey(state: PagingState<Int, PokeVersion>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokeVersion> {
        val result = api.get(Version(params.loadSize, params.key ?: 0))
        Log.d("TAG", "key=${params.key}, next=${result.nextOffset}")

        return LoadResult.Page(
            result.results,
            prevKey = null,
            nextKey = result.nextOffset
        )
    }
}

