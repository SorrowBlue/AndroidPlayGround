package com.sorrowblue.android.playground.compose.poke.model.common

import kotlinx.serialization.Serializable

@Serializable
data class PokePagination<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
