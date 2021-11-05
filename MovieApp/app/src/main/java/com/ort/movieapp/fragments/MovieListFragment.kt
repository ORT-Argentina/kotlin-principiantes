package com.ort.movieapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ort.movieapp.R
import com.ort.movieapp.adapter.MoviesAdapter
import com.ort.movieapp.entities.MovieRepository
import com.ort.movieapp.viewmodels.MovieListViewModel

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private lateinit var viewModel: MovieListViewModel

    private lateinit var v : View
    private lateinit var recMovie : RecyclerView
    private var repository = MovieRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.movie_list_fragment, container, false)
        recMovie = v.findViewById(R.id.recMovie)
        return v
    }

    override fun onStart() {
        super.onStart()

        recMovie.setHasFixedSize(true)

        recMovie.layoutManager  = LinearLayoutManager(context)

        recMovie.adapter = MoviesAdapter(repository.getMovies()){ index ->
            onItemClick(index)
        }

    }

    fun onItemClick (pos : Int){

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}