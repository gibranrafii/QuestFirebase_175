package com.example.myfirebase.view.controlNavigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfirebase.view.DetailSiswaScreen
import com.example.myfirebase.view.EditSiswaScreen
import com.example.myfirebase.view.EntrySiswaScreen
import com.example.myfirebase.view.route.DestinasiDetail
import com.example.myfirebase.view.route.DestinasiEntry
import com.example.myfirebase.view.route.DestinasiHome
import com.example.myfirebase.view.HomeScreen
import com.example.myfirebase.view.route.DestinasiEdit

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = modifier) {
        composable (DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(DestinasiEntry.
            route) },
        navigateToItemUpdate = {
            navController.navigate("${DestinasiDetail.route}/${it}") })
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route) })
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetail.itemIdArg) { type = NavType.StringType }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEdit.route}/$id")
                },
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }

        composable(
            DestinasiEdit.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEdit.itemIdArg) { type = NavType.StringType }
            )
        ) {
        }
    }
}