package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.model.Animal

class EnclosureDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animals = intent.getSerializableExtra("animals") as? ArrayList<Animal>

        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "",
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Détails",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Animaux présents dans l'enclos :",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp)
                )

                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    animals?.forEach {
                        item {
                            Text(
                                text = "• ${it.name}",
                                fontSize = 14.sp
                            )
                            Spacer(Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EnclosureDetailsScreen() {
    Text("Enclosure Details")

}