package com.kay.powerups.ui.fragments

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color.red
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.kay.powerups.R
import com.kay.powerups.databinding.FragmentPowerUpDescriptionBinding

class PowerUpDescriptionFragment : Fragment() {

    private var _binding: FragmentPowerUpDescriptionBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<PowerUpDescriptionFragmentArgs>()

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentPowerUpDescriptionBinding.inflate(inflater, container, false)

        binding.currentTitle.text = args.currentItem.title
        binding.currentDescription.text = args.currentItem.description
        binding.CurrentImageViewUrl.load(args.currentItem.imageUrl)
        binding.tvLongDescription.text = args.currentItem.longDescription
        binding.testThisTv.text = args.currentItem.storeUrl
        //binding.btnConnect.text = args.currentItem.connected.toString()
        if (args.currentItem.connected) {
            binding.btnConnect.setText("Disconnect from Tibber")
            binding.btnConnect.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(requireContext(), R.color.disconnect_color), BlendModeCompat.SRC_ATOP)/*backgroundTintList = ColorStateList.valueOf(R.color.disconnect_color)*/
        } else {
            binding.btnConnect.setText("Connect To Tibber")
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
