package com.universidad.proyectofinal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supply")
data class Supply(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val price: Double,
    val reference: String,
    val quantity: String
)
