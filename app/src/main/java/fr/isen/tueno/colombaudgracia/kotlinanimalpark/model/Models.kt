package fr.isen.tueno.colombaudgracia.kotlinanimalpark.model

import java.io.Serializable

data class Animal(
    val id: String = "",
    val name: String = ""
) : Serializable

data class Enclosure(
    val id: String = "",
    val animals: List<Animal> = emptyList()
)

data class Biome(
    val id: String = "",
    val name: String = "",
    val color: String = "",
    val enclosures: List<Enclosure> = emptyList()
)