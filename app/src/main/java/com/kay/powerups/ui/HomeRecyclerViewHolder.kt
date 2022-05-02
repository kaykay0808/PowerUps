package com.kay.powerups.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.kay.powerups.databinding.ItemHeaderBinding
import com.kay.powerups.databinding.ItemPowerUpsRowBinding

sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bindHeader(header: PowerUpListItem.Header) {
            binding.tvHeader.text = header.title
        }
    }

    class PowerUpsHolder(private val binding: ItemPowerUpsRowBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bindPowerUps(powerUps: PowerUpListItem.PowerUpUiModel) {
            binding.imageViewUrl.load(powerUps.uiModel.imageUrl)
            binding.tvNamePowerUp.text = powerUps.uiModel.title
            binding.tvDescription.text= powerUps.uiModel.description
        }
    }
}