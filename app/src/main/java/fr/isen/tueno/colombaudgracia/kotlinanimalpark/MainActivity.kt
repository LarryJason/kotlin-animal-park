package fr.isen.tueno.colombaudgracia.kotlinanimalpark

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.material.tabs.TabLayout.TabView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.ButtomNavigationBar
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.EnclosuresListScreen
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.HomeScreen
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.User
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.userScreen
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.theme.KotlinAnimalParkTheme

data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null
)

sealed class Routes(val route: String, val label: String, val icon: ImageVector) {
    object Home: Routes("Home", "Home", Icons.Default.Home)
    object Enclos: Routes("Enclos", "Enclos", Icons.Default.Lock)
    object Profile: Routes("User", "User", Icons.Default.Person)
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { ButtomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Routes.Home.route) { HomeScreen() }
            composable(Routes.Enclos.route) { EnclosuresListScreen() }
            composable(Routes.Profile.route) { userScreen() }
        }
    }
}