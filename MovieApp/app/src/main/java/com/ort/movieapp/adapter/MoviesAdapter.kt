package com.ort.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.movieapp.R
import com.ort.movieapp.entities.Movie

class MoviesAdapter (
    var movieList : MutableList <Movie>,
    var onClick : (Int) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    class MovieHolder (v: View) : RecyclerView.ViewHolder(v) {

        private var view: View

        init {
            this.view = v
        }

        fun setTitle (title : String){
            var txtTitle : TextView = view.findViewById(R.id.txtTitleMovie)
            txtTitle.text = title
        }

        fun getCardView () : CardView {
            return view.findViewById(R.id.cardMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return (MovieHolder(view))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
       holder.setTitle(movieList[position].title)
       holder.getCardView().setOnClickListener {
           onClick(position)
       }
    }

    override fun getItemCount(): Int {
      return movieList.size
    }

}