package com.kay.powerups.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kay.powerups.databinding.FragmentListBinding
import com.kay.powerups.ui.ListPowerUpsViewModel
import com.kay.powerups.ui.PowerUpListItem
import com.kay.powerups.ui.fragments.adapter.ListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListPowerUpsViewModel by viewModel()
    private val adapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getInfo()

        // recycler view
        recyclerViewSetup()

        // observe LiveData
        viewModel.liveData.observe(viewLifecycleOwner, { setupList(it) })
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            binding.recyclerView.isVisible = it == null
        }
    }

    private fun recyclerViewSetup() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun setupList(data: List<PowerUpListItem>) {
        adapter.setData(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
