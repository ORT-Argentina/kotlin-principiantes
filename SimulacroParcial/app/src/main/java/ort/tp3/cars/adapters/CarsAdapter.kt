package ort.tp3.cars.adapters

import android.content.Context
import ort.tp3.cars.dataclasses.CarModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import ort.tp3.cars.R

class CarsAdapter(private val context: Context, private val carsList: List<CarModel>) :
    RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    fun setCarsList(carsList: List<CarModel>) {
        (this.carsList as ArrayList).clear()
        this.carsList.addAll(carsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val car = carsList[position]
        holder.bind(car)
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    inner class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carBrandTextView: TextView = itemView.findViewById(R.id.carBrand)
        private val carLogoImageView: ImageView = itemView.findViewById(R.id.carLogoImageView)
        private val carModelTextView: TextView = itemView.findViewById(R.id.carModelTextView)
        private val carDriveTextView: TextView = itemView.findViewById(R.id.carDriveTextView)
        private val carTransmission: TextView = itemView.findViewById(R.id.carTransmission)
        private val carYearTextView: TextView = itemView.findViewById(R.id.carYearTextView)
        private val carFuelTypeTextView: TextView = itemView.findViewById(R.id.carFuelTypeTextView)

        fun bind(car: CarModel) {
            val fuelText = car.getConvertedFuelType()
            val transmissionText = car.getConvertedTransmission()
            val driveText = car.getConvertedDrive()
            val carBrandText = car.getConvertedMake()

            carModelTextView.text = car.model
            carDriveTextView.text = driveText
            carTransmission.text = transmissionText
            carYearTextView.text = car.year.toString()
            carFuelTypeTextView.text = fuelText
            carBrandTextView.text = carBrandText

            val requestOptions = RequestOptions().transform(CircleCrop())


            Glide.with(context)
                .load(car.getMakerLogo())
                .apply(requestOptions)
                .fitCenter()
                .override(180, 180)
                .into(carLogoImageView)
        }

    }
}

