package com.example.traveldiary

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.traveldiary.ui.screens.addTravel.AddTravelScreen
import com.example.traveldiary.ui.screens.home.HomeScreen
import com.example.traveldiary.ui.screens.settings.SettingsScreen
import com.example.traveldiary.ui.screens.travelDetails.TravelDetailsScreen
import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object
    Main : NavigationRoute
    @Serializable
    data object Travel : NavigationRoute
    @Serializable
    data class TravelDetails(val travelId: String) : NavigationRoute
    @Serializable
    data object Settings : NavigationRoute
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavigationRoute.Main)
    {
        composable<NavigationRoute.Main> { HomeScreen(navController) }
        composable<NavigationRoute.Travel> { AddTravelScreen(navController) }
        composable<NavigationRoute.TravelDetails> { backStackEntry ->
            val route = backStackEntry.toRoute<NavigationRoute.TravelDetails>()
            TravelDetailsScreen(navController, route.travelId) }
        composable<NavigationRoute.Settings>{ SettingsScreen(navController) }
    }
}

