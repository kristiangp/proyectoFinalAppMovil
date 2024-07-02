package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.ProductSale

@Dao
interface ProductSaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productSale: ProductSale)

    @Query("SELECT * FROM product_sale WHERE productId = :productId AND saleId = :saleId")
    suspend fun getProductSales(productId: Int, saleId: Int): List<ProductSale>
}

