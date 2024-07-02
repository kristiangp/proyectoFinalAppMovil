package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.Vehicle
import com.universidad.proyectofinal.data.repository.VehicleRepository
import kotlinx.coroutines.launch

class VehicleViewModel(private val vehicleRepository: VehicleRepository) : ViewModel() {

    private val _vehicles = MutableLiveData<List<Vehicle>>()
    val vehicles: LiveData<List<Vehicle>> get() = _vehicles

    fun fetchVehicles() {
        viewModelScope.launch {
            _vehicles.value = vehicleRepository.getVehicles() // Usar el método que devuelve la lista de vehículos
        }
    }
}

