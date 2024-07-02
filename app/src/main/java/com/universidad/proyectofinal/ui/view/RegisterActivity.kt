package com.universidad.proyectofinal.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.data.db.AppDatabase
import com.universidad.proyectofinal.data.model.User
import com.universidad.proyectofinal.data.repository.UserRepository
import com.universidad.proyectofinal.databinding.ActivityRegisterBinding
import com.universidad.proyectofinal.ui.viewmodel.UserViewModel
import com.universidad.proyectofinal.ui.viewmodel.UserViewModelFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(AppDatabase.getDatabase(applicationContext).userDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConfirmar.setOnClickListener {
            val user = User(
                id = binding.editTextRegisterCedula.text.toString(),
                name = binding.editTextRegisterName.text.toString(),
                email = binding.editTextRegisterEmail.text.toString(),
                password = binding.editTextRegisterPassword.text.toString(),
                role = binding.spinnerRole.selectedItem.toString()
            )

            userViewModel.insertUser(user)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual para evitar que el usuario regrese con el botón de retroceso
        }
    }
}
