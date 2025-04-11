package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens.ui.theme.KotlinAnimalParkTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }

    }
}

@Composable
fun HomeScreen() {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 25.dp),
        ) {
            Text(text = "Accueil",
                fontSize = 25.sp,
//                fontWeight = 50.sp
            )
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column () {
                Button(onClick = { /*TODO*/ },
                  shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp)
                        ) {
                    Text(text = "Informations générales")
                }
                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp)) {
                    Text(text = "Règles")
                }
                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp)) {
                    Text(text = "Service d'urgence")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    KotlinAnimalParkTheme {
    }
}