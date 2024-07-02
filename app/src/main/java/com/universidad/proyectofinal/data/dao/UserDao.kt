package com.universidad.proyectofinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universidad.proyectofinal.data.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE id = :userId LIMIT 1")
    suspend fun getUser(userId: String): List<User> // Cambio aquí: devuelve List<User>
}



