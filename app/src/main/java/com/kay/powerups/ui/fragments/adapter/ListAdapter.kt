package com.kay.powerups.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.powerups.databinding.ItemPowerUpsRowBinding
import com.kay.powerups.ui.PowerUpsUiModel

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    var dataList = emptyList<PowerUpsUiModel>()

    class MyViewHolder (val binding: ItemPowerUpsRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return MyViewHolder(ItemPowerUpsRowBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvNamePowerUp.text = dataList[position].title
        holder.binding.tvDescription.text = dataList[position].description

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newData: List<PowerUpsUiModel>){
        this.dataList = newData
        notifyDataSetChanged()
    }
}