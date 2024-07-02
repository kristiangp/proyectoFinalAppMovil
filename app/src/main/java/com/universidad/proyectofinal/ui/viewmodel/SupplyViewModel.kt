package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.Supply
import com.universidad.proyectofinal.data.repository.SupplyRepository
import kotlinx.coroutines.launch

class SupplyViewModel(private val supplyRepository: SupplyRepository) : ViewModel() {

    private val _supplies = MutableLiveData<List<Supply>>()
    val supplies: LiveData<List<Supply>> get() = _supplies

    fun fetchSupplies() {
        viewModelScope.launch {
            _supplies.value = supplyRepository.getSupplies() // Usa el método que devuelve la lista de suministros
        }
    }
}


