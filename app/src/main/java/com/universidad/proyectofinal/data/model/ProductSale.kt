package com.universidad.proyectofinal.data.model

import androidx.room.Entity

@Entity(tableName = "product_sale", primaryKeys = ["productId", "saleId"])
data class ProductSale(
    val productId: Int,
    val saleId: Int,
    val quantity: String
)
