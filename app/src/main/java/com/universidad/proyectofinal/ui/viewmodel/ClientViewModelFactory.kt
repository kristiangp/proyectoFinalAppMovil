package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universidad.proyectofinal.data.repository.ClientRepository

class ClientViewModelFactory(private val clientRepository: ClientRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClientViewModel(clientRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
