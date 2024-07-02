package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.ProductSaleDao
import com.universidad.proyectofinal.data.model.ProductSale

class ProductSaleRepository(private val productSaleDao: ProductSaleDao) {

    suspend fun insert(productSale: ProductSale) {
        productSaleDao.insert(productSale)
    }

    suspend fun getProductSales(productId: Int, saleId: Int): List<ProductSale> {
        return productSaleDao.getProductSales(productId, saleId)
    }
}

