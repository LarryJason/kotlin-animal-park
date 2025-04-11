package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.Routes
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.TabBarItem
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.ui.theme.KotlinAnimalParkTheme

@Composable
fun ButtomNavigationBar(navController: NavController){
    val items = listOf(
        Routes.Home,
        Routes.Enclos,
        Routes.Profile
    )
    BottomAppBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        items.forEach{
            route ->
            BottomNavigationItem(
                icon = {Icon(route.icon, contentDescription = route.label) },
                label = {Text(route.label)},
                selected = currentRoute == route.route,
                onClick = {
                    if (currentRoute!= route.route) {
                        navController.navigate(route.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }

}