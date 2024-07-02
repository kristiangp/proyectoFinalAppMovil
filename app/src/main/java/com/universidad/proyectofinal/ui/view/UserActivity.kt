package com.universidad.proyectofinal.ui.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.data.db.AppDatabase
import com.universidad.proyectofinal.databinding.ActivityUserBinding
import com.universidad.proyectofinal.ui.adaptadores.UserAdapter
import com.universidad.proyectofinal.ui.viewmodel.UserViewModel

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setupRecyclerView()

        // Llamar a la función para obtener la lista de usuarios
        fetchUsers()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(emptyList()) // Inicialmente vacío, se llenará con los datos obtenidos
        binding.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@UserActivity)
        }
    }

    private fun fetchUsers() {
        val userId = getCurrentUserId()
        if (userId != null) {
            viewModel.getUser(userId) { users -> // Cambio aquí: obtener lista de usuarios
                userAdapter.updateUsers(users) // Actualizar adaptador con la lista de usuarios
            }
        } else {
            // Manejar el caso donde no hay usuario actualmente autenticado
            // Por ejemplo, redirigir a MainActivity para iniciar sesión
            // o mostrar un mensaje al usuario.
        }
    }

    private fun getCurrentUserId(): String? {
        val sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        return sharedPreferences.getString("current_user_id", null)
    }
}

