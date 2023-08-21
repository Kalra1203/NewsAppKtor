package com.example.newsappktor.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String?,
    val name: String?
)

fun Source.toName() : String? {
    return name
}