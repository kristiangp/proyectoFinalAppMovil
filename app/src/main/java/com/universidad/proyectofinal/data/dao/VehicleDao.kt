package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.Vehicle

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle WHERE id = :vehicleId")
    suspend fun getVehicle(vehicleId: String): Vehicle?

    @Query("SELECT * FROM vehicle")
    suspend fun getAllVehicles(): List<Vehicle> // Método para obtener todos los vehículos
}
