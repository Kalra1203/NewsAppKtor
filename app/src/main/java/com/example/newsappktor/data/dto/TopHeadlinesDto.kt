package com.example.newsappktor.data.dto

import com.example.newsappktor.domain.model.Article
import kotlinx.serialization.Serializable

@Serializable
data class TopHeadlinesDto(
    val articles: List<Articles>,
    val status: String?,
    val totalResults: Int?
)


