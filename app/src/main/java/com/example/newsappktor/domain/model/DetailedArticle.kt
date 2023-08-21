package com.example.newsappktor.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DetailedArticle(
    val author: String?,
    val content: String?,
    val description: String?,
    val title: String?,
    val urlToImage: String?
)
