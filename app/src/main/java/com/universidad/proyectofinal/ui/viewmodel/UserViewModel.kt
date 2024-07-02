package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.User
import com.universidad.proyectofinal.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    fun getUser(userId: String, callback: (List<User>) -> Unit) { // Cambio aquí: callback recibe List<User>
        viewModelScope.launch {
            val users = userRepository.getUser(userId) // Cambio aquí: obtener lista de usuarios
            callback(users)
        }
    }

    // Método de inicio de sesión que verifica las credenciales
    fun loginUser(userId: String, password: String, callback: (User?) -> Unit) {
        viewModelScope.launch {
            val users = userRepository.getUser(userId)
            val user = users.firstOrNull { it.password == password }
            callback(user)
        }
    }
}
