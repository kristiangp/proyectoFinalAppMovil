package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.VehicleDao
import com.universidad.proyectofinal.data.model.Vehicle

class VehicleRepository(private val vehicleDao: VehicleDao) {

    suspend fun insert(vehicle: Vehicle) {
        vehicleDao.insert(vehicle)
    }

    suspend fun getVehicles(): List<Vehicle> {
        return vehicleDao.getAllVehicles()
    }
}
