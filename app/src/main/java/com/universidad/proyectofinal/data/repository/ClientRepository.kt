package com.universidad.proyectofinal.data.repository

import com.universidad.proyectofinal.data.dao.ClientDao
import com.universidad.proyectofinal.data.model.Client

class ClientRepository(private val clientDao: ClientDao) {

    suspend fun insert(client: Client) {
        clientDao.insert(client)
    }

    suspend fun getClients(): List<Client> { // Cambiado para obtener una lista de clientes
        return clientDao.getClients()
    }
}


