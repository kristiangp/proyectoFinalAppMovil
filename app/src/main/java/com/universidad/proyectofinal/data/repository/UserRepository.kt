package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.UserDao
import com.universidad.proyectofinal.data.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getUser(userId: String): List<User> {
        return userDao.getUser(userId)
    }
}


