package com.universidad.proyectofinal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val customerId: String,
    val vehicleId: Int,
    val supplyId: Int,
    val vehicleQuantity: Int,
    val supplyQuantity: Int,
    val totalPrice: Double,
    val amount: String
)
