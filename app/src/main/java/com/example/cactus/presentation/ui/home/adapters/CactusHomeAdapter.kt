package com.example.cactus.presentation.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cactus.data.remote.dto.CactusDto
import com.example.cactus.databinding.ItemCactusHomeBinding

class CactusHomeAdapter(private val context:Context,private var cactusList:ArrayList<CactusDto>) :
    RecyclerView.Adapter<CactusHomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCactusHomeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCactusHomeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cactusList[position]
        holder.binding.textTitle.text = item.title
//        holder.binding.textCost.text = item.id.toString()
//        holder.binding.imageCactus.setImageResource(item.url!!.toInt())

    }

    override fun getItemCount(): Int = cactusList.count()

    fun setData(cactusList: ArrayList<CactusDto>){
        this.cactusList = cactusList
        notifyDataSetChanged()
    }
}