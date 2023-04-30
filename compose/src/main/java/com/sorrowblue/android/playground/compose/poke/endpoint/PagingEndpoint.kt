package com.sorrowblue.android.playground.compose.poke.endpoint

import kotlinx.serialization.Serializable

@Serializable
sealed interface PagingEndpoint<T> : Endpoint<T> {
    val limit: Int
    val offset: Int
}
