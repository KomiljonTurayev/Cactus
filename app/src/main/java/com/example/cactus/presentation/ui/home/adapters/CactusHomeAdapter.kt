package com.example.cactus.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cactus.databinding.ItemCactusHomeBinding
import com.example.cactus.domain.model.Cactus

class CactusHomeAdapter(
    private var cactusList: List<Cactus> = emptyList(),
    private val onAddClick: (Cactus) -> Unit = {}
) :
    RecyclerView.Adapter<CactusHomeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCactusHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cactus) {
            binding.textTitle.text = item.title
            binding.imageCactus.load(item.url) {
                crossfade(true)
                placeholder(android.R.drawable.progress_horizontal)
                error(android.R.drawable.stat_notify_error)
            }
            binding.btnAddToCart.setOnClickListener { onAddClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCactusHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cactusList[position])
    }

    override fun getItemCount(): Int = cactusList.size

    fun setData(newList: List<Cactus>) {
        this.cactusList = newList
        notifyDataSetChanged()
    }
}