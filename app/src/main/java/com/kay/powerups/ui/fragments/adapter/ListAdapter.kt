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

const val VIEW_TYPE_SECTION = 1
const val VIEW_TYPE_ITEM = 2

class ListAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>(){ /* Removed the -> ListAdapter.MyViewHolder*/
    var dataList = emptyList<PowerUpListItem>() // <- maybe replace this
    var items = listOf<HomeRecyclerViewHolder>()

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
            is HomeRecyclerViewHolder.HeaderViewHolder -> holder.bindHeader(items[position] as PowerUpListItem.Header)
            is HomeRecyclerViewHolder.PowerUpsHolder -> holder.bindPowerUps(items[position] as PowerUpListItem.PowerUpUiModel)
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
         when (items[position]){
            is HomeRecyclerViewHolder.HeaderViewHolder -> R.layout.item_header
            is HomeRecyclerViewHolder.PowerUpsHolder -> R.layout.item_power_ups_row
        }
        return VIEW_TYPE_ITEM
    }

    fun setData(newData: List<PowerUpsUiModel>){
        this.dataList = newData
        notifyDataSetChanged()
    }

}