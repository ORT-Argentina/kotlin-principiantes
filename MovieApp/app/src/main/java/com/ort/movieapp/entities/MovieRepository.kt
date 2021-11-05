package com.ort.movieapp.entities

class MovieRepository {

    private var movieList : MutableList<Movie> = mutableListOf()

    init{
        movieList.add(Movie("Rocky1","RockyDescription",""))
        movieList.add(Movie("Rocky2","RockyDescription",""))
        movieList.add(Movie("Rocky3","RockyDescription",""))
        movieList.add(Movie("Rocky4","RockyDescription",""))
        movieList.add(Movie("Rocky5","RockyDescription",""))
        movieList.add(Movie("Rocky6","RockyDescription",""))
        movieList.add(Movie("Rocky1","RockyDescription",""))
        movieList.add(Movie("Rocky2","RockyDescription",""))
        movieList.add(Movie("Rocky3","RockyDescription",""))
        movieList.add(Movie("Rocky4","RockyDescription",""))
        movieList.add(Movie("Rocky5","RockyDescription",""))
        movieList.add(Movie("Rocky6","RockyDescription",""))
        movieList.add(Movie("Rocky1","RockyDescription",""))
        movieList.add(Movie("Rocky2","RockyDescription",""))
        movieList.add(Movie("Rocky3","RockyDescription",""))
        movieList.add(Movie("Rocky4","RockyDescription",""))
        movieList.add(Movie("Rocky5","RockyDescription",""))
        movieList.add(Movie("Rocky6","RockyDescription",""))
    }

    fun getMovies () : MutableList<Movie>{
        return movieList
    }
}