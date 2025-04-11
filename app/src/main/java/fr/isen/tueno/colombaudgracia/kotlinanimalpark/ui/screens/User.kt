package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.ui.theme.KotlinAnimalParkTheme

class User : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            userScreen()
        }

    }
}

@Composable
fun userScreen() {
    val context = LocalContext.current
    val user = FirebaseAuth.getInstance().currentUser

    Row(
        modifier = Modifier
            .padding(start = 40.dp, top = 25.dp)
    ) {
        Text(
            text = "Profile",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Avatar de l'utilisateur


        Spacer (modifier = Modifier.height (16.dp))

        // Nom de l'utilisateur
        Text(
            text = user?.displayName ?: "Utilisateur inconnu",
            fontSize = 20.sp,
            fontWeight = FontWeight .Bold
        )

        // Email de l'utilisateur
        Text(
            text = user?.email ?: "Email inconnu",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Bouton de déconnexion
        Button(
            onClick = {
                FirebaseAuth.getInstance().signOut()
                val intent= Intent(context ,Login::class.java)
                context.startActivity(intent)
                 // Rediriger vers la page de connexion
            }
        ) {
            Text("Se déconnecter")
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview5() {
//    KotlinAnimalParkTheme {
//        Greeting2("Android")
//    }
//}