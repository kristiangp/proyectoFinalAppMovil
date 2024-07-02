package com.universidad.proyectofinal.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.data.db.AppDatabase
import com.universidad.proyectofinal.data.repository.ClientRepository
import com.universidad.proyectofinal.databinding.ActivityClientBinding
import com.universidad.proyectofinal.ui.adaptadores.ClientAdapter
import com.universidad.proyectofinal.ui.viewmodel.ClientViewModel
import com.universidad.proyectofinal.ui.viewmodel.ClientViewModelFactory

class ClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientBinding
    private val clientViewModel: ClientViewModel by viewModels {
        ClientViewModelFactory(ClientRepository(AppDatabase.getDatabase(applicationContext).clientDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        clientViewModel.clients.observe(this, Observer { clients ->
            binding.recyclerView.adapter = ClientAdapter(clients)
        })

        clientViewModel.fetchClients()
    }
}
