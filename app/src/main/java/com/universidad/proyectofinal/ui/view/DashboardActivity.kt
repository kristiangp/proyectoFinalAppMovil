package com.universidad.proyectofinal.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.databinding.LayoutDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: LayoutDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName")
        binding.textViewUserName.text = userName

        binding.buttonCerrarSesion.setOnClickListener {
            // Lógica para cerrar sesión
            finish()
        }

        binding.buttonClientes.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            intent.putExtra("formType", "cliente")
            startActivity(intent)
        }

        binding.buttonVehiculos.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            intent.putExtra("formType", "vehiculo")
            startActivity(intent)
        }

        binding.buttonInsumos.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            intent.putExtra("formType", "insumo")
            startActivity(intent)
        }

        binding.buttonVenta.setOnClickListener {
            val intent = Intent(this, VentaActivity::class.java)
            startActivity(intent)
        }
    }
}
