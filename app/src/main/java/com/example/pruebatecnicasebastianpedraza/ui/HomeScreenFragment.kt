package com.example.pruebatecnicasebastianpedraza.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.pruebatecnicasebastianpedraza.R
import com.example.pruebatecnicasebastianpedraza.databinding.FragmentHomeScreenBinding
import com.example.pruebatecnicasebastianpedraza.ui.adapter.HomeAttributesAdapter

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen),
    HomeAttributesAdapter.OnAttributeClickListener {
    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //list of the columns on the Heat map
        val attributesList = listOf(
            "Operating cost",
            "Annual turnover",
            "number of operators",
            "Amount of energy",
            "Budget execution level"
        )
        binding = FragmentHomeScreenBinding.bind(view)
        binding.rvAttributes.adapter = HomeAttributesAdapter(attributesList, this)
    }

    //impl of OnAttributeClickListener interface
    override fun onAttributeClick(item: String) {
        //nav components - safeargs
        val action =
            HomeScreenFragmentDirections.actionHomeScreenFragmentToSortedProejctsFragment(item)
        findNavController().navigate(action)
    }
}