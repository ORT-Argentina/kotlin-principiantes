package com.ort.edu.challengepractica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ort.edu.challengepractica.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailFragment : Fragment() {

    private lateinit var description: TextView
    private lateinit var price: TextView
    private lateinit var productImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        description = view.findViewById(R.id.product_description)
        price = view.findViewById(R.id.product_price)
        productImage = view.findViewById(R.id.product_image)

        arguments?.let {
            val product = ProductDetailFragmentArgs.fromBundle(it).product

            description.text = product.description
            price.text = "$${product.price}"
            Glide.with(this)
                .load(product.imageLink)
                .into(productImage)
        }

    }

}