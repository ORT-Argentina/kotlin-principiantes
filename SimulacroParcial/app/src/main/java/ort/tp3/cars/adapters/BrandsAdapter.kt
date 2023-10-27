package ort.tp3.cars.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel

class BrandsAdapter(private val context: Context, private val brands: List<BrandsModel>) :
    RecyclerView.Adapter<BrandsAdapter.ViewHolder>() {

    private var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(brand: BrandsModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val brand = brands[position]
        holder.bind(brand)
    }

    override fun getItemCount(): Int {
        return brands.size
    }

    fun setBrands(brands: List<BrandsModel>) {
        (this.brands as ArrayList).clear()
        this.brands.addAll(brands)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.brandImageView)
        private val textView: TextView = itemView.findViewById(R.id.brandTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(brands[position])
                }
            }
        }

        fun bind(brand: BrandsModel) {
            textView.text = brand.name

            Glide.with(context)
                .load(brand.logoUrl)
                .fitCenter()
                .override(180, 180)
                .into(imageView)
        }
    }
}
