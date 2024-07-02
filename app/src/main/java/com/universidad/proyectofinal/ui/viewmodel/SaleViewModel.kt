package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.Sale
import com.universidad.proyectofinal.data.repository.SaleRepository
import kotlinx.coroutines.launch

class SaleViewModel(private val saleRepository: SaleRepository) : ViewModel() {

    private val _sales = MutableLiveData<List<Sale>>()
    val sales: LiveData<List<Sale>> get() = _sales

    fun fetchSales() {
        viewModelScope.launch {
            _sales.value = saleRepository.getSales() // Llama al método que devuelve la lista de ventas
        }
    }
}
