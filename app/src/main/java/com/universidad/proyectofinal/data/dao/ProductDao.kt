package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Query("SELECT * FROM product WHERE id = :productId")
    suspend fun getProduct(productId: Int): Product?

    @Query("SELECT * FROM product")
    suspend fun getProducts(): List<Product> // Método para obtener todos los productos
}
