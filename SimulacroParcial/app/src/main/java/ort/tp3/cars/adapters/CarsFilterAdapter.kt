package ort.tp3.cars.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.CarFilterModel

class CarsFilterAdapter(private val context: Context, private val filters: List<CarFilterModel>) :
    RecyclerView.Adapter<CarsFilterAdapter.ViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(filter: CarFilterModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_car_filter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filter = filters[position]
        holder.bind(filter)
    }

    override fun getItemCount(): Int {
        return filters.size
    }

    fun setFilters(filters: List<CarFilterModel>) {
        (this.filters as MutableList).clear()
        this.filters.addAll(filters)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carTitleTextView: TextView = itemView.findViewById(R.id.carTitleTextView)
        private val carFilterImageButton: ImageView =
            itemView.findViewById(R.id.carFilterImageButton)
        private val carCardView: CardView = itemView.findViewById(R.id.carCardView)

        init {
            carCardView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val filter = filters[position]
                    itemClickListener?.onItemClick(filter)
                }
            }
        }

        fun bind(filter: CarFilterModel) {
            carTitleTextView.text = filter.title
            carFilterImageButton.setImageResource(filter.imageResId)
            val cardBackgroundColor = Color.parseColor(filter.backgroundColor)
            carCardView.setCardBackgroundColor(cardBackgroundColor)
        }
    }
}

