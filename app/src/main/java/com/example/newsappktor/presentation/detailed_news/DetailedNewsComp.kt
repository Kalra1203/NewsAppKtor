package com.example.newsappktor.presentation.detailed_news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsappktor.domain.model.DetailedArticle

//@Composable
//fun DetailedNewsComp(detailedArticle: DetailedArticle) {
//    Column(modifier = Modifier.fillMaxSize()) {
//        detailedArticle.title?.let { Text(text = it) }
//        Spacer(modifier = Modifier.height(10.dp))
//        detailedArticle.description?.let { Text(text = it) }
//        Spacer(modifier = Modifier.height(10.dp))
//        AsyncImage(
//            model = detailedArticle.urlToImage,
//            contentDescription = detailedArticle.description,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.25f)
//                .padding(horizontal = 15.dp)
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        detailedArticle.content?.let { Text(text = it) }
//
//    }
//
//}

@Composable
fun DetailedNewsComp(title: String?, description: String?, image: ImageVector?, content: String?) {
    title?.let { Text(text = it) }
    Spacer(modifier = Modifier.height(10.dp))
    description?.let { Text(text = it) }
    Spacer(modifier = Modifier.height(10.dp))
    AsyncImage(
        model = image,
        contentDescription = description,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .padding(horizontal = 15.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
    content?.let { Text(text = it) }


}

