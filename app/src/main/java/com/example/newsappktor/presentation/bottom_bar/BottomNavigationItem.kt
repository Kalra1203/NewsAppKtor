package com.example.newsappktor.presentation.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector

) {
    object Breaking : BottomNavigationItem("Breaking News","braking News" , Icons.Filled.Home, Icons.Default.Home)
    object Saved : BottomNavigationItem("Saved News","saved News", Icons.Filled.Favorite, Icons.Default.Favorite)
    object Search : BottomNavigationItem("Search News","search news", Icons.Filled.Search, Icons.Default.Search)
}
