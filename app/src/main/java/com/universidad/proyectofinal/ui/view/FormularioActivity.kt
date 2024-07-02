package com.universidad.proyectofinal.ui.view


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.universidad.proyectofinal.databinding.LayoutFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: LayoutFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formType = intent.getStringExtra("formType")

        when (formType) {
            "vehiculo" -> showVehiculoFields()
            "cliente" -> showClienteFields()
            "insumo" -> showInsumoFields()
        }

        binding.buttonGuardar.setOnClickListener {
            // Lógica para guardar los datos
        }
    }

    private fun showVehiculoFields() {
        binding.editTextMarca.visibility = View.VISIBLE
        binding.editTextColor.visibility = View.VISIBLE
        binding.editTextPlaca.visibility = View.VISIBLE
        binding.editTextModelo.visibility = View.VISIBLE
    }

    private fun showClienteFields() {
        binding.editTextNombre.visibility = View.VISIBLE
        binding.editTextApellido.visibility = View.VISIBLE
        binding.editTextCedulaFormulario.visibility = View.VISIBLE
        binding.editTextEdad.visibility = View.VISIBLE
        binding.editTextGenero.visibility = View.VISIBLE
    }

    private fun showInsumoFields() {
        binding.editTextNombreInsumo.visibility = View.VISIBLE
        binding.editTextPrecio.visibility = View.VISIBLE
        binding.editTextReferencia.visibility = View.VISIBLE
    }
}
