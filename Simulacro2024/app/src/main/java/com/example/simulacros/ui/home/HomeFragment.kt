package com.example.simulacros.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulacros.adapters.DogListAdapter
import com.example.simulacros.databinding.FragmentHomeBinding
import com.example.simulacros.domain.model.Dog
import com.example.simulacros.listener.OnViewItemClickedListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnViewItemClickedListener {
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recDogs = binding.recDogs

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })

        viewModel.listDog.observe(viewLifecycleOwner, Observer {
            recDogs.adapter = DogListAdapter(it ?: listOf(), this)
        })

        var dogsListAdapter = DogListAdapter(listOf(), this)
        recDogs.setHasFixedSize(true)
        recDogs.layoutManager = LinearLayoutManager(context)
        recDogs.adapter = dogsListAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewItemDetail(dog: Dog){
        view?.findNavController()?.navigate(HomeFragmentDirections.actionNavigationHomeToDetailFragment3(dog))
    }
}