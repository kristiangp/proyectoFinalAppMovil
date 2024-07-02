package com.universidad.proyectofinal.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.data.db.AppDatabase
import com.universidad.proyectofinal.data.repository.UserRepository
import com.universidad.proyectofinal.databinding.ActivityMainBinding
import com.universidad.proyectofinal.ui.viewmodel.UserViewModel
import com.universidad.proyectofinal.ui.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(AppDatabase.getDatabase(applicationContext).userDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIngresar.setOnClickListener {
            val cedula = binding.editTextCedula.text.toString()
            val contrasena = binding.editTextPassword.text.toString()

            userViewModel.getUser(cedula) { user ->
                if (user != null && user.password == contrasena) {
                    // Guardar el ID del usuario en SharedPreferences
                    val sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("current_user_id", user.id).apply()

                    // Redirigir al tercer layout (DashboardActivity)
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra("userName", user.name)
                    startActivity(intent)
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.buttonRegistrarse.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
