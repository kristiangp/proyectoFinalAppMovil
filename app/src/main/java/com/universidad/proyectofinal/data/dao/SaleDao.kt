package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.Sale

@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sale: Sale)

    @Query("SELECT * FROM sale WHERE id = :saleId")
    suspend fun getSale(saleId: String): Sale?

    @Query("SELECT * FROM sale")
    suspend fun getSales(): List<Sale> // Método para obtener todas las ventas
}
