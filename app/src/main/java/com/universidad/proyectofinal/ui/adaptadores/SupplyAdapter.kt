package com.universidad.proyectofinal.ui.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universidad.proyectofinal.databinding.ItemSupplyBinding
import com.universidad.proyectofinal.data.model.Supply

class SupplyAdapter(private val supplies: List<Supply>) : RecyclerView.Adapter<SupplyAdapter.SupplyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplyViewHolder {
        val binding = ItemSupplyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SupplyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SupplyViewHolder, position: Int) {
        holder.bind(supplies[position])
    }

    override fun getItemCount(): Int = supplies.size

    class SupplyViewHolder(private val binding: ItemSupplyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(supply: Supply) {
            binding.supplyName.text = supply.name
            binding.supplyQuantity.text = supply.quantity.toString()
        }
    }
}
