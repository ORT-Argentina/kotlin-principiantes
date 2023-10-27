package ort.tp3.cars.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R
import ort.tp3.cars.adapters.CarsAdapter
import ort.tp3.cars.ui.viewmodels.CarsViewModel

@AndroidEntryPoint
class CarsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var carsAdapter: CarsAdapter
    private val carsViewModel: CarsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("CarsFragment", "onCreateView")

        carsViewModel.onCreate()
        carsAdapter = CarsAdapter(requireContext(), mutableListOf())

        return inflater.inflate(R.layout.fragment_cars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isLoading = view.findViewById<View>(R.id.loading)
        recyclerView = view.findViewById(R.id.rec_cars)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = carsAdapter

        carsViewModel.carsList.observe(viewLifecycleOwner) {
            carsAdapter.setCarsList(it)
        }

        carsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            isLoading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        carsViewModel.clear()
    }
}
