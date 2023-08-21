package com.example.newsappktor.presentation.breaking_news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsappktor.domain.model.Article

@Composable
fun BreakingNewsComp(article: List<Article>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(article) { article ->
            SingleArticle(article = article)


        }

    }


}

@Composable
fun SingleArticle(article: Article) {
    Column {
//        article.title?.let { Text(text = it, color = Color.Blue, fontSize = 18.sp
//        ) }
//        Spacer(modifier = Modifier.height(10.dp))
//
//        AsyncImage(model = article.urlToImage, contentDescription = article.description)
//        Spacer(modifier = Modifier.height(10.dp))
//
//        article.description?.let { Text(text = it, maxLines = 4, overflow = TextOverflow.Ellipsis, color= Color.Magenta) }
//        Spacer(modifier = Modifier.height(10.dp))
//
//        article.publishedAt?.let { Text(text = it, modifier = Modifier.align(Alignment.End), color = Color.Black) }
//
//        Spacer(modifier = Modifier.height(10.dp))
//        Divider(modifier = Modifier
//            .fillMaxWidth()
//            .height(3.dp), color = Color.Black)
//        Spacer(modifier = Modifier.height(20.dp))

        AsyncImage(model = article.urlToImage, contentDescription = article.description)
        Spacer(modifier = Modifier.height(10.dp))
        article.title?.let { Text(text = it, fontSize = 24.sp, color = Color.Black) }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(horizontalArrangement = Arrangement.Start) {
                article.source?.name?.let { Text(text = it, color = Color.LightGray) }

            }
            Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Save News")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Share News")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More Options")
                }

            }

        }


    }

}
