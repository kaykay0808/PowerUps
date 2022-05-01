package com.kay.powerups.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.kay.powerups.databinding.FragmentPowerUpDescriptionBinding

class PowerUpDescriptionFragment : Fragment() {

    private var _binding: FragmentPowerUpDescriptionBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<PowerUpDescriptionFragmentArgs>()

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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
