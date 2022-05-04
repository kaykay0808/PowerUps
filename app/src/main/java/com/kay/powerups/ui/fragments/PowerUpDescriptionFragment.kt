package com.kay.powerups.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
        binding.tvMoreAbout.setText("More About ${args.currentItem.title}")

        buttonConnectedCheck()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Tibber Store Button
        binding.btnTibberStore.setOnClickListener{
            // Loading Url webpage
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(args.currentItem.storeUrl))
            startActivity(browserIntent)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun buttonConnectedCheck() {
        if (args.currentItem.connected) {
            binding.btnConnect.setText("Disconnect from Tibber")
            binding.btnConnect.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.dissconnect_custom_oval_button
            )
            binding.btnConnect.setTextColor(R.color.disconnect_color)
        } else {
            binding.btnConnect.setText("Connect To Tibber")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
