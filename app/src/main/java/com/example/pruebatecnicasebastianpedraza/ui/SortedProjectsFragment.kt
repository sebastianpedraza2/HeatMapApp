package com.example.pruebatecnicasebastianpedraza.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pruebatecnicasebastianpedraza.R
import com.example.pruebatecnicasebastianpedraza.core.Resource
import com.example.pruebatecnicasebastianpedraza.data.remote.HeatMapDataSource
import android.view.View
import com.example.pruebatecnicasebastianpedraza.data.model.Project
import com.example.pruebatecnicasebastianpedraza.databinding.FragmentSortedProejctsBinding
import com.example.pruebatecnicasebastianpedraza.presentation.HeatMapViewModel
import com.example.pruebatecnicasebastianpedraza.presentation.HeatMapViewModelFactory
import com.example.pruebatecnicasebastianpedraza.repository.HeatMapRepoImpl
import com.example.pruebatecnicasebastianpedraza.ui.adapter.HomeScreenAdapter


class SortedProjectsFragment : Fragment(R.layout.fragment_sorted_proejcts) {
    private val args by navArgs<SortedProjectsFragmentArgs>()

    //Manual dependencies injection
    private val viewModel by viewModels<HeatMapViewModel> {
        HeatMapViewModelFactory(HeatMapRepoImpl(HeatMapDataSource()))
    }
    private lateinit var binding: FragmentSortedProejctsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSortedProejctsBinding.bind(view)
        val attribute = args.attributeToSort
        binding.txtAttribute.text = attribute
        ViewCompat.setNestedScrollingEnabled(binding.rvProjects, false)

        //viewModel arq
        viewModel.fetchProjects().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressMainMenu.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("Firebase1", "Resultados : ${result.data.size}")
                    val projectsList = result.data
                    //Sorting the list of data based on the different attributes
                    var sortedList = listOf<Project>()
                    when (attribute) {
                        "Operating cost" -> sortedList =
                            projectsList.sortedBy { it.operating_cost }
                        "Annual turnover" -> sortedList =
                            projectsList.sortedBy { it.annual_turnover }
                        "number of operators" -> sortedList =
                            projectsList.sortedBy { it.number_of_operators }
                        "Amount of energy" -> sortedList =
                            projectsList.sortedBy { it.amount_of_energy }
                        "Budget execution level" -> sortedList =
                            projectsList.sortedBy { it.budget_execution_level }
                    }
                    //Defining the (More/avg/fewer) colors
                    val sizeOfEachSegment = sortedList.size / 3
                    sortedList.forEachIndexed { index, project ->
                        if (index <= sizeOfEachSegment) {
                            project.color_background = "Red"
                        } else if (index > sizeOfEachSegment && index <= (sizeOfEachSegment * 2)) {
                            project.color_background = "grey"
                        } else {
                            project.color_background = "Blue"
                        }
                    }
                    binding.progressMainMenu.visibility = View.GONE
                    binding.rvProjects.adapter =
                        HomeScreenAdapter(projectsList)
                }
                //Failure scenario
                is Resource.Failure -> {
                    binding.progressMainMenu.visibility = View.GONE
                    Toast.makeText(
                        context,
                        "Ha ocurrido un erro: ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

}