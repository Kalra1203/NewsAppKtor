package com.example.newsappktor.domain.model

import com.example.newsappktor.data.dto.Source
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String?,
    val description: String?,
    val publishedAt: String?,
    val urlToImage: String?,
    val source: Source?,

    )
