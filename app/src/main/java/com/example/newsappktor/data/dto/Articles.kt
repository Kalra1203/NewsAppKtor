package com.example.newsappktor.data.dto

import com.example.newsappktor.domain.model.Article
import com.example.newsappktor.domain.model.DetailedArticle
import kotlinx.serialization.Serializable

@Serializable
data class Articles(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

fun Articles.toArticle() : Article {
    return Article(
        title = title,
        description= description,
        publishedAt= publishedAt,
        urlToImage= urlToImage,
        source = source
    )

}

fun Articles.toDetailedArticle() : DetailedArticle{
    return DetailedArticle(
        author= author,
        content= content,
        description= description,
        title= title,
        urlToImage= urlToImage
    )
}