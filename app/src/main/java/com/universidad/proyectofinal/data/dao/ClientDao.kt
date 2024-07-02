package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.Client

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(client: Client)

    @Query("SELECT * FROM client")
    suspend fun getClients(): List<Client> // Método para obtener una lista de clientes
}

