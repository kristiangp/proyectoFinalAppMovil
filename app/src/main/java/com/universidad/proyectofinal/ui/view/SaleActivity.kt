package com.universidad.proyectofinal.ui.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.databinding.ActivitySaleBinding
import com.universidad.proyectofinal.ui.adaptadores.SaleAdapter
import com.universidad.proyectofinal.ui.viewmodel.SaleViewModel

class SaleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySaleBinding
    private val saleViewModel: SaleViewModel by viewModels()

    private lateinit var saleAdapter: SaleAdapter // Declara el adaptador como lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa el adaptador con una lista vacía
        saleAdapter = SaleAdapter()
        binding.recyclerView.adapter = saleAdapter

        // Observa los cambios en la lista de ventas desde el ViewModel
        saleViewModel.sales.observe(this, Observer { sales ->
            saleAdapter.submitList(sales) // Actualiza la lista de ventas en el adaptador
        })

        // Carga las ventas desde el ViewModel
        saleViewModel.fetchSales()
    }
}
