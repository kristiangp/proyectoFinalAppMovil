package com.universidad.proyectofinal.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.databinding.ActivityProductSaleBinding
import com.universidad.proyectofinal.ui.adaptadores.ProductSaleAdapter
import com.universidad.proyectofinal.ui.viewmodel.ProductSaleViewModel

class ProductSaleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductSaleBinding
    private val productSaleViewModel: ProductSaleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Aquí asumo que debes pasar los IDs adecuados para obtener las ventas de productos
        val productId = 1 // Ejemplo: ID del producto
        val saleId = 1 // Ejemplo: ID de la venta

        productSaleViewModel.productSales.observe(this, Observer { productSales ->
            binding.recyclerView.adapter = ProductSaleAdapter(productSales)
        })

        productSaleViewModel.fetchProductSales(productId, saleId)
    }
}

