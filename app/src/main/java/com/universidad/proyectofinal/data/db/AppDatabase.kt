package com.universidad.proyectofinal.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.universidad.proyectofinal.data.dao.ClientDao
import com.universidad.proyectofinal.data.dao.ProductDao
import com.universidad.proyectofinal.data.dao.ProductSaleDao
import com.universidad.proyectofinal.data.dao.SaleDao
import com.universidad.proyectofinal.data.dao.SupplyDao
import com.universidad.proyectofinal.data.dao.UserDao
import com.universidad.proyectofinal.data.dao.VehicleDao
import com.universidad.proyectofinal.data.model.Client
import com.universidad.proyectofinal.data.model.Product
import com.universidad.proyectofinal.data.model.ProductSale
import com.universidad.proyectofinal.data.model.Sale
import com.universidad.proyectofinal.data.model.Supply
import com.universidad.proyectofinal.data.model.User
import com.universidad.proyectofinal.data.model.Vehicle

@Database(entities = [User::class, Client::class, Product::class, Supply::class, Vehicle::class, ProductSale::class, Sale::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun clientDao(): ClientDao
    abstract fun productDao(): ProductDao
    abstract fun supplyDao(): SupplyDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun saleDao(): SaleDao
    abstract fun productSaleDao(): ProductSaleDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
