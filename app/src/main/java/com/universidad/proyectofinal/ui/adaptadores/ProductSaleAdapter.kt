package com.universidad.proyectofinal.ui.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universidad.proyectofinal.databinding.ItemProductSaleBinding
import com.universidad.proyectofinal.data.model.ProductSale

class ProductSaleAdapter(private val productSales: List<ProductSale>) : RecyclerView.Adapter<ProductSaleAdapter.ProductSaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductSaleViewHolder {
        val binding = ItemProductSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductSaleViewHolder, position: Int) {
        holder.bind(productSales[position])
    }

    override fun getItemCount(): Int = productSales.size

    class ProductSaleViewHolder(private val binding: ItemProductSaleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productSale: ProductSale) {
            binding.productSaleId.text = "${productSale.productId}-${productSale.saleId}"
            binding.productSaleQuantity.text = productSale.quantity.toString()
        }
    }
}

