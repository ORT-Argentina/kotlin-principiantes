package ort.tp3.cars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ort.tp3.cars.R
import ort.tp3.cars.adapters.BrandsAdapter
import ort.tp3.cars.adapters.CarsFilterAdapter
import ort.tp3.cars.data.CarsRepository
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.dataclasses.CarFilterModel
import ort.tp3.cars.ui.viewmodels.CarsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val carsViewModel: CarsViewModel by activityViewModels()

    @Inject
    lateinit var carsRepository: CarsRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup the brands RecyclerView
        val brandRecyclerView: RecyclerView = view.findViewById(R.id.brandRecyclerView)
        val brandLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        brandRecyclerView.layoutManager = brandLayoutManager
        val brandAdapter = BrandsAdapter(requireContext(), mutableListOf())
        brandRecyclerView.adapter = brandAdapter

        brandAdapter.setOnItemClickListener(object : BrandsAdapter.OnItemClickListener {
            override fun onItemClick(brand: BrandsModel) {
                handleBrandClick(brand)
            }
        })

        lifecycleScope.launch {
            val brands = carsRepository.getAvailableBrands()
            brandAdapter.setBrands(brands)
        }

        // Setup the filter RecyclerView
        val filterRecyclerView: RecyclerView = view.findViewById(R.id.filterRecyclerView)
        val filterLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        filterRecyclerView.layoutManager = filterLayoutManager
        val filterAdapter = CarsFilterAdapter(requireContext(), mutableListOf())
        filterRecyclerView.adapter = filterAdapter

        filterAdapter.setOnItemClickListener(object : CarsFilterAdapter.OnItemClickListener {
            override fun onItemClick(filter: CarFilterModel) {
                handleFilterClick(filter)
            }
        })

        lifecycleScope.launch {
            val filters = carsRepository.getAvailableFilters()
            filterAdapter.setFilters(filters)
        }
    }

    fun handleBrandClick(brand: BrandsModel) {
        carsViewModel.setFilter(mapOf("make" to brand.name))

        val navController = findNavController()
        navController.navigate(R.id.action_home_to_cars)
    }

    fun handleFilterClick(filter: CarFilterModel) {
        carsViewModel.setFilter(mapOf("fuel_type" to filter.value))

        val navController = findNavController()
        navController.navigate(R.id.action_home_to_cars)
    }
}
