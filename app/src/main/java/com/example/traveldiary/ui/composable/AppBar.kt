package com.example.traveldiary.ui.composable


import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.traveldiary.NavigationRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title : String, navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    /*val title = when {
        backStackEntry?.destination?.hasRoute<NavigationRoute.Screen1>() == true -> "Screen 1"
        backStackEntry?.destination?.hasRoute<NavigationRoute.Screen2>() == true -> "Screen 2"
        backStackEntry?.destination?.hasRoute<NavigationRoute.Screen3>() == true -> "Screen 3"
        else -> "Unknown Screen"
    }*/
    CenterAlignedTopAppBar(
        title = {
            Text(
                title,
                fontWeight = FontWeight.Medium,
            )
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.AutoMirrored.Outlined.ArrowBack, "Go Back")
                }
            }
        },
        actions = {
            if (title == "TravelDiary") {
                IconButton(onClick = {  }) {
                    Icon(Icons.Outlined.Search, contentDescription = "Search")
                }
            }
            if (title != "Settings") {
                IconButton(onClick = { navController.navigate(NavigationRoute.Settings) }) {
                    Icon(Icons.Outlined.Settings, "Settings")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}
