package com.universidad.proyectofinal.ui.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.universidad.proyectofinal.data.model.Sale
import com.universidad.proyectofinal.databinding.ItemSaleBinding

class SaleAdapter : ListAdapter<Sale, SaleAdapter.SaleViewHolder>(SaleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val binding = ItemSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val sale = getItem(position)
        holder.bind(sale)
    }

    class SaleViewHolder(private val binding: ItemSaleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sale: Sale) {
            binding.saleId.text = sale.id.toString()
            binding.saleAmount.text = sale.amount.toString()
        }
    }

    // Clase utilitaria para comparar elementos en la lista
    class SaleDiffCallback : DiffUtil.ItemCallback<Sale>() {
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.id == newItem.id // Cambia esto según el identificador único de Sale
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem // Implementa una comparación más detallada si es necesario
        }
    }
}
