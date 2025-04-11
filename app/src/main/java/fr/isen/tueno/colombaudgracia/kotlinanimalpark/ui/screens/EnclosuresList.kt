package fr.isen.tueno.colombaudgracia.kotlinanimalpark.ui.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.model.Animal
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.model.Biome
import fr.isen.tueno.colombaudgracia.kotlinanimalpark.model.Enclosure

class EnclosuresList : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnclosuresListScreen()
        }

    }
}

@Composable
fun EnclosuresListScreen() {

    val database = FirebaseDatabase.getInstance().reference
    var biomeList by remember { mutableStateOf<List<Biome>>(emptyList()) }

    fetchBiomes(database) {
        biomeList = it
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Les enclos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally))
        BiomeList(biomes = biomeList)
    }

}


fun fetchBiomes(
    database: DatabaseReference,
    onResult: (List<Biome>) -> Unit
) {
    database.get().addOnSuccessListener { snapshot ->
        val biomes = snapshot.children.mapNotNull { biomeSnapshot ->
            val name = biomeSnapshot.child("name").getValue(String::class.java) ?: return@mapNotNull null
            val color = biomeSnapshot.child("color").getValue(String::class.java) ?: "#FFFFFF"

            val enclosures = biomeSnapshot.child("enclosures").children.mapNotNull { encSnapshot ->
                val id = encSnapshot.child("id").getValue(String::class.java) ?: return@mapNotNull null
                val animals = encSnapshot.child("animals").children.mapNotNull { aniSnapshot ->
                    val aniId = aniSnapshot.child("id").getValue(String::class.java) ?: return@mapNotNull null
                    val aniName = aniSnapshot.child("name").getValue(String::class.java) ?: return@mapNotNull null
                    Animal(aniId, aniName)
                }
                Enclosure(id, animals)
            }

            Biome(
                id = biomeSnapshot.child("id").getValue(String::class.java) ?: "",
                name = name,
                color = color,
                enclosures = enclosures
            )
        }

        onResult(biomes)
    }
}

@Composable
fun BiomeList(biomes: List<Biome>) {
    val context = LocalContext.current
    LazyColumn {
        biomes.forEach { biome ->
            items(biome.enclosures) { enclosure ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            val intent = Intent(context, EnclosureDetails::class.java)
                            intent.putExtra("animals", ArrayList(enclosure.animals))
                            context.startActivity(intent)
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(android.graphics.Color.parseColor(biome.color))
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Enclos ${enclosure.id}", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Animaux:")
                        enclosure.animals.forEach { animal ->
                            Text("- ${animal.name}")
                        }
                    }
                }
            }
        }
    }
}