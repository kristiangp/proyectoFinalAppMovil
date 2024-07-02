package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.SaleDao
import com.universidad.proyectofinal.data.model.Sale

class SaleRepository(private val saleDao: SaleDao) {

    suspend fun insert(sale: Sale) {
        saleDao.insert(sale)
    }

    suspend fun getSale(saleId: String): Sale? {
        return saleDao.getSale(saleId)
    }

    suspend fun getSales(): List<Sale> { // Método para obtener todas las ventas
        return saleDao.getSales()
    }
}

