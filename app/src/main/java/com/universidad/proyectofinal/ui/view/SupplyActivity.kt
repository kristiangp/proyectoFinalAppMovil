package com.universidad.proyectofinal.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.databinding.ActivitySupplyBinding
import com.universidad.proyectofinal.ui.adaptadores.SupplyAdapter
import com.universidad.proyectofinal.ui.viewmodel.SupplyViewModel

class SupplyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySupplyBinding
    private val supplyViewModel: SupplyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        supplyViewModel.supplies.observe(this, Observer { supplies ->
                binding.recyclerView.adapter = SupplyAdapter(supplies)
        })

        supplyViewModel.fetchSupplies()
    }
}
