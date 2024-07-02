package com.universidad.proyectofinal.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universidad.proyectofinal.data.model.ProductSale
import com.universidad.proyectofinal.data.repository.ProductSaleRepository
import kotlinx.coroutines.launch

class ProductSaleViewModel(private val productSaleRepository: ProductSaleRepository) : ViewModel() {

    private val _productSales = MutableLiveData<List<ProductSale>>()
    val productSales: LiveData<List<ProductSale>> get() = _productSales

    fun fetchProductSales(productId: Int, saleId: Int) {
        viewModelScope.launch {
            _productSales.value = productSaleRepository.getProductSales(productId, saleId)
        }
    }
}

