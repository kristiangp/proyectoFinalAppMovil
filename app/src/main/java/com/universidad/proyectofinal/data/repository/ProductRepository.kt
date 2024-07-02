package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.ProductDao
import com.universidad.proyectofinal.data.model.Product

class ProductRepository(private val productDao: ProductDao) {

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun getProduct(productId: Int): Product? {
        return productDao.getProduct(productId)
    }

    suspend fun getProducts(): List<Product> { // Método para obtener todos los productos
        return productDao.getProducts()
    }
}

