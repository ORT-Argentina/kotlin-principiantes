package com.example.simulacros.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.simulacros.R
import com.example.simulacros.databinding.FragmentIntroBinding
import com.example.simulacros.ui.home.HomeFragmentDirections
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = IntroFragment()
    }

    private val viewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val introViewModel = ViewModelProvider(this).get(IntroViewModel::class.java)

        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnStart: Button = binding.introBtnStart
        btnStart.setOnClickListener() {
            view?.findNavController()?.navigate(IntroFragmentDirections.actionNavigationIntroToNavigationHome())
        }

        return root
    }

    override fun onStart() {
        super.onStart()

        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        navBar.visibility = View.GONE

        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.custom_toolbar)
        toolbar.visibility = View.GONE

    }
}