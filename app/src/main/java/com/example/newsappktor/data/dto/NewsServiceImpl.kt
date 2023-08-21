package com.example.newsappktor.data.dto

import android.util.Log
import com.example.newsappktor.common.Constants
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class NewsServiceImpl(
    private val client: HttpClient
) : NewsService {
    override suspend fun getTopHeadlines(): TopHeadlinesDto {
        return try {
            client.get {
                url(Constants.TOP_HEADLINES)
                parameter("country", "in")
                parameter("apiKey", Constants.API_KEY)
            }
        } catch (e: RedirectResponseException) {
            // for 3xx response
            println("Redirect Error : ${e.response.status.description}")
            Log.d("karan", "Error : ${e.response.status.description}")
            TopHeadlinesDto(
                articles = emptyList(),
                status = e.response.status.description,
                totalResults = 0
            )
        } catch (e: ClientRequestException) {
            // for 4xx response
            println("Cleint Error : ${e.response.status.description}")
            Log.d("karan", "Cleint Error : ${e.response.status.description}")
            TopHeadlinesDto(
                articles = emptyList(),
                status = e.response.status.description,
                totalResults = 0
            )
        } catch (e: ServerResponseException) {
            // for 5xx response
            println("Server Error : ${e.response.status.description}")
            Log.d("karan", "Server Error : ${e.response.status.description}")

            TopHeadlinesDto(
                articles = emptyList(),
                status = e.response.status.description,
                totalResults = 0
            )
        } catch (e: Exception) {
            println("Exception Error : ${e.message}")
            Log.d("karan", "Exception Error : ${e.message}")

            TopHeadlinesDto(
                articles = emptyList(),
                status = e.message.toString(),
                totalResults = 0
            )
        }

    }
}
