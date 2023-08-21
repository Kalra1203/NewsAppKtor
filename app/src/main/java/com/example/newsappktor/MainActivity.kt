package com.example.newsappktor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsappktor.data.dto.Articles
import com.example.newsappktor.data.dto.NewsService
import com.example.newsappktor.data.dto.toArticle
import com.example.newsappktor.domain.model.Article
import com.example.newsappktor.presentation.bottom_bar.BottomNavigationItem
import com.example.newsappktor.presentation.breaking_news.BreakingNewsComp
import com.example.newsappktor.presentation.saved_news.SavedNewsComp
import com.example.newsappktor.presentation.search_news.SearchNewsComp
import com.example.newsappktor.ui.theme.NewsAppKtorTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {


    private val service = NewsService.create()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppKtorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val items = listOf(
                        BottomNavigationItem.Breaking,
                        BottomNavigationItem.Search,
                        BottomNavigationItem.Saved
                    )
                    var selectedItemIndex by rememberSaveable {
                        mutableStateOf(0)
                    }
                    val topHeadlines = produceState<List<Articles>>(
                        initialValue = emptyList(),
                        producer = {
                            value = service.getTopHeadlines().articles

                        })
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            NavigationBar(modifier = Modifier.wrapContentHeight()) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(item.route) {
//                                                // Pop up to the start destination of the graph to
//                                                // avoid building up a large stack of destinations
//                                                // on the back stack as users select items
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
//                                                // Avoid multiple copies of the same destination when
//                                                // reselecting the same item
                                                launchSingleTop = true
//                                                // Restore state when reselecting a previously selected item
                                                restoreState = true
                                            }
                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                        alwaysShowLabel = false,
                                        icon = {
                                            Icon(
                                                imageVector = if (selectedItemIndex == index) item.selectedIcon else item.unSelectedIcon,
                                                contentDescription = item.title
                                            )
                                        })

                                }
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController,
                            startDestination = BottomNavigationItem.Breaking.route,
                            Modifier.padding(innerPadding)
                        ) {
                            composable(BottomNavigationItem.Breaking.route) {
                                BreakingNewsComp(
                                    topHeadlines.value.map { it.toArticle() })
                            }
                            composable(BottomNavigationItem.Search.route) { SearchNewsComp() }
                            composable(BottomNavigationItem.Saved.route) { SavedNewsComp() }
                        }

                    }
                }
            }
        }
    }

}

