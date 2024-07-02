package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.Supply

@Dao
interface SupplyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(supply: Supply)

    @Query("SELECT * FROM supply WHERE id = :supplyId")
    suspend fun getSupply(supplyId: String): Supply?

    @Query("SELECT * FROM supply")
    suspend fun getAllSupplies(): List<Supply> // Método para obtener todos los suministros
}
