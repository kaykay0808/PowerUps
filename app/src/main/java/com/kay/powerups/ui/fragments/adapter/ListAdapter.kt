package com.kay.powerups.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.powerups.R
import com.kay.powerups.databinding.ItemHeaderBinding
import com.kay.powerups.databinding.ItemPowerUpsRowBinding
import com.kay.powerups.ui.HomeRecyclerViewHolder
import com.kay.powerups.ui.PowerUpListItem
import com.kay.powerups.ui.PowerUpsUiModel

class ListAdapter :
    RecyclerView.Adapter<HomeRecyclerViewHolder>() {
    private var dataList = emptyList<PowerUpListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.item_header -> HomeRecyclerViewHolder.HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            R.layout.item_power_ups_row -> HomeRecyclerViewHolder.PowerUpsHolder(
                ItemPowerUpsRowBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        when (holder) {
            is HomeRecyclerViewHolder.HeaderViewHolder -> holder.bindHeader(dataList[position] as PowerUpListItem.Header)
            is HomeRecyclerViewHolder.PowerUpsHolder -> holder.bindPowerUps(dataList[position] as PowerUpsUiModel)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is PowerUpListItem.Header -> R.layout.item_header

            is PowerUpsUiModel -> R.layout.item_power_ups_row
        }
    }

    fun setData(newData: List<PowerUpListItem>) {
        this.dataList = newData
        notifyDataSetChanged()
    }
}
