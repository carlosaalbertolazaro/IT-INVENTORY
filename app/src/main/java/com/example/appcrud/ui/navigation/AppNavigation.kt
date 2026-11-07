package com.example.appcrud.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcrud.ui.screens.HomeScreen
import com.example.appcrud.ui.screens.LoginScreen
import com.example.appcrud.ui.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onGoToRegister = { navController.navigate("register") }
            )
        }
        composable("register") {
            RegisterScreen(
                onGoToLogin = { navController.navigate("login") },
                onGoToHome = { navController.navigate("home") }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}