package com.universidad.proyectofinal.ui.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.databinding.LayoutListaVentasBinding

class ListaVentasActivity : AppCompatActivity() {

    private lateinit var binding: LayoutListaVentasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutListaVentasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lógica para mostrar la lista de ventas
    }
}
