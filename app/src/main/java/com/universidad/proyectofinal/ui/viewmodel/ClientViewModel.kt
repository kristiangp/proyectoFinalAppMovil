package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.Client
import com.universidad.proyectofinal.data.repository.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val clientRepository: ClientRepository) : ViewModel() {

    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> get() = _clients

    fun fetchClients() {
        viewModelScope.launch {
            _clients.value = clientRepository.getClients() // Cambiado para obtener una lista de clientes
        }
    }
}


