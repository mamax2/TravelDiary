package com.example.traveldiary

import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object
    Main : NavigationRoute
    @Serializable
    data object Travel : NavigationRoute
    @Serializable
    data object TravelDetails : NavigationRoute
    @Serializable
    data object Settings : NavigationRoute
}