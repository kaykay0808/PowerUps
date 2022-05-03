package com.kay.powerups.ui.fragments.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kay.powerups.R
import com.kay.powerups.databinding.ItemHeaderBinding
import com.kay.powerups.databinding.ItemPowerUpsRowBinding
import com.kay.powerups.ui.HomeRecyclerViewHolder
import com.kay.powerups.ui.PowerUpListItem
import com.kay.powerups.ui.PowerUpsUiModel
import com.kay.powerups.ui.fragments.ListFragmentDirections
import java.lang.IllegalArgumentException

class ListAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>(){ /* Removed the -> ListAdapter.MyViewHolder*/
    var dataList = emptyList<PowerUpListItem>() // <- maybe replace this

    class MyViewHolder (val binding: ItemPowerUpsRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
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
        when(holder){
            is HomeRecyclerViewHolder.HeaderViewHolder -> holder.bindHeader(dataList[position] as PowerUpListItem.Header)
            is HomeRecyclerViewHolder.PowerUpsHolder -> holder.bindPowerUps(dataList[position] as PowerUpsUiModel)
        }

        /*val thisImage = dataList[position]
        holder.binding.imageViewUrl.load(thisImage.imageUrl) {
            crossfade(600)
            error(R.drawable.ic_launcher_background)
        }
        holder.binding.tvNamePowerUp.text = dataList[position].title
        holder.binding.tvDescription.text = dataList[position].description

        // navigate with Item
        holder.binding.rowBackground.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToPowerUpDescriptionFragment(dataList[position])
            holder.itemView.findNavController().navigate(action)
        }*/

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

    fun setData(newData: List<PowerUpListItem>){
        this.dataList = newData
        notifyDataSetChanged()
    }

}