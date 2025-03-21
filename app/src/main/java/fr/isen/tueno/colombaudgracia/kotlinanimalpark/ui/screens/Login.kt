package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.ui.theme.KotlinAnimalParkTheme

class Login : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen()
        }
    }

}

@Composable
fun LoginScreen() {

    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    val context = LocalContext.current


    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 102.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Connectez-vous",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 250.dp),

        )
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 350.dp)
    ) {
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 450.dp)
    ) {
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text("Mot de passe")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    Spacer(modifier = Modifier.height(10.dp))
    Row {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 550.dp)
        ) {
            Text("Se connecter")
        }
    }
    Box(modifier = Modifier
        .padding(top = 650.dp, start = 50.dp),
        contentAlignment = Alignment.Center
    ){
        Row {
            Text(text = "Vous n'avez pas de compte?")
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Inscrivez-vous!",
                modifier = Modifier
                    .clickable {
                        val intent = Intent(context, Register::class.java)
                        context.startActivity(intent)
                    }
                )
        }
        
        
    }
}
    

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KotlinAnimalParkTheme {
        
    }
}