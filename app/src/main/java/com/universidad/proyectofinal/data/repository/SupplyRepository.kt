package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.SupplyDao
import com.universidad.proyectofinal.data.model.Supply

class SupplyRepository(private val supplyDao: SupplyDao) {

    suspend fun insert(supply: Supply) {
        supplyDao.insert(supply)
    }

    suspend fun getSupplies(): List<Supply> {
        return supplyDao.getAllSupplies() // Cambia el nombre del método según corresponda
    }
}

