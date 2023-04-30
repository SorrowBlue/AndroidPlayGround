package com.sorrowblue.android.playground.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.map
import com.sorrowblue.android.playground.compose.poke.PokeApi
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersion
import com.sorrowblue.android.playground.compose.poke.model.game.PokeVersionGroup
import com.sorrowblue.android.playground.compose.poke.model.game.resource
import com.sorrowblue.android.playground.compose.poke.model.location.PokeRegion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeRegionListScreen(api: PokeApi) {
    val pagingItems = pokeRegionPagingList(api).collectAsLazyPagingItems()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(pagingItems) { sample ->
                ListItem(
                    headlineText = { Text(sample?.names?.japanease ?: sample?.name ?: "") },
                    trailingContent = { Icon(Icons.Default.KeyboardArrowRight, "") },
                    modifier = Modifier.clickable { })
                Divider()
            }
        }
    }
}

private fun pokeRegionPagingList(api: PokeApi): Flow<PagingData<PokeRegion>> {
    return Pager(PagingConfig(pageSize = 10, initialLoadSize = 10)) {
        PokeRegionPagingSource(api)
    }.flow
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeVersionListScreen(api: PokeApi, action: () -> Unit) {
    val pagingItems = pokeVersionPagingList(api).collectAsLazyPagingItems()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(pagingItems) { sample ->
                val version = sample?.first
                val versionGroup = sample?.second
                ListItem(
                    headlineText = {
                        Text(
                            version?.names?.japanease ?: version?.name ?: ""
                        )
                    },
                    supportingText = { Text(versionGroup?.name ?: "") },
                    trailingContent = { Icon(Icons.Default.KeyboardArrowRight, "") },
                    modifier = Modifier.clickable { action.invoke() })
                Divider()
            }
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
private fun pokeVersionPagingList(api: PokeApi): Flow<PagingData<Pair<PokeVersion, PokeVersionGroup>>> {
    return Pager(PagingConfig(pageSize = 10, initialLoadSize = 10)) {
        PokeVersionPagingSource(api)
    }.flow.mapLatest {
        it.map {
            it to api.get(it.versionGroup.resource)
        }
    }
}
