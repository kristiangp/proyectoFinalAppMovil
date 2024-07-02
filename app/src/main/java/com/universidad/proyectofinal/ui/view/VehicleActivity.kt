package com.universidad.proyectofinal.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universidad.proyectofinal.databinding.ActivityVehicleBinding
import com.universidad.proyectofinal.ui.adaptadores.VehicleAdapter
import com.universidad.proyectofinal.ui.viewmodel.VehicleViewModel

class VehicleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVehicleBinding
    private val vehicleViewModel: VehicleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        vehicleViewModel.vehicles.observe(this, Observer { vehicles ->
                binding.recyclerView.adapter = VehicleAdapter(vehicles)
        })

        vehicleViewModel.fetchVehicles()
    }
}
