package com.universidad.proyectofinal.ui.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.databinding.LayoutVentaBinding

class VentaActivity : AppCompatActivity() {

    private lateinit var binding: LayoutVentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutVentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            // Lógica para calcular el total y almacenar la venta
        }
    }
}
