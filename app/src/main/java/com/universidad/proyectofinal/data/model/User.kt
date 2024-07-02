package com.universidad.proyectofinal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val id: String,
    val name: String,
    val password: String,
    val role: String,
    val email: String
)