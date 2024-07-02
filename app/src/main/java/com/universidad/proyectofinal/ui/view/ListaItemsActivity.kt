package com.universidad.proyectofinal.ui.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.databinding.LayoutListaItemsBinding

class ListaItemsActivity : AppCompatActivity() {

    private lateinit var binding: LayoutListaItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutListaItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lógica para mostrar la lista de vehículos e insumos
    }
}
