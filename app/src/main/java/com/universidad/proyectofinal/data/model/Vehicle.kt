package com.universidad.proyectofinal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle")
data class Vehicle(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val brand: String,
    val color: String,
    val plate: String,
    val model: String
)
