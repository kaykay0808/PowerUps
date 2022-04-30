package com.kay.powerups.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kay.powerups.R
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
        val thisImage = dataList[position]
        holder.binding.imageViewUrl.load(thisImage.imageUrl) {
            crossfade(600)
            error(R.drawable.ic_launcher_background)
        }
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