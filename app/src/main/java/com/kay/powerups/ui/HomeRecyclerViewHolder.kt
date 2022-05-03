package com.kay.powerups.ui

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.kay.powerups.R
import com.kay.powerups.databinding.ItemHeaderBinding
import com.kay.powerups.databinding.ItemPowerUpsRowBinding
import com.kay.powerups.ui.fragments.ListFragmentDirections

sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bindHeader(header: PowerUpListItem.Header) {
            binding.tvHeader.text = header.title
        }
    }

    class PowerUpsHolder(private val binding: ItemPowerUpsRowBinding) :
        HomeRecyclerViewHolder(binding) {
        fun bindPowerUps(powerUp: PowerUpsUiModel) {
            binding.imageViewUrl.load(powerUp.imageUrl)
            binding.tvNamePowerUp.text = powerUp.title
            binding.tvDescription.text= powerUp.description

            binding.rowBackground.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToPowerUpDescriptionFragment(powerUp)
                itemView.findNavController().navigate(action)

            }
        }
    }
}
/*holder.binding.rowBackground.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToPowerUpDescriptionFragment(dataList[position])
            holder.itemView.findNavController().navigate(action)
        }*/