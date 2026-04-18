package com.example.cactus.presentation.ui.basket.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cactus.databinding.ItemBasketBinding
import com.example.cactus.domain.model.BasketItem

class BasketAdapter(
    private var items: List<BasketItem> = emptyList(),
    private val onRemoveClick: (BasketItem) -> Unit
) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BasketItem) {
            binding.textTitle.text = item.cactus.title
            binding.textQuantity.text = "Qty: ${item.quantity}"
            binding.textPrice.text = "$${item.quantity * 25}.00"
            binding.imageCactus.load(item.cactus.url) {
                crossfade(true)
            }
            binding.btnRemove.setOnClickListener { onRemoveClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBasketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setData(newList: List<BasketItem>) {
        this.items = newList
        notifyDataSetChanged()
    }
}
