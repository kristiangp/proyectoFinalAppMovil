package com.universidad.proyectofinal.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.databinding.ActivityProductBinding
import com.universidad.proyectofinal.ui.adaptadores.ProductAdapter
import com.universidad.proyectofinal.ui.viewmodel.ProductViewModel

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        productViewModel.products.observe(this, Observer { products ->
                binding.recyclerView.adapter = ProductAdapter(products)
        })

        productViewModel.fetchProducts()
    }
}
