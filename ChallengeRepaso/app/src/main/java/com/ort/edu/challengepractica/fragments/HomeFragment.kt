package com.ort.edu.challengepractica.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.challengepractica.R
import com.ort.edu.challengepractica.UserSession
import com.ort.edu.challengepractica.adapter.ProductAdapter
import com.ort.edu.challengepractica.listener.OnProductClickedListener
import com.ort.edu.challengepractica.model.Product
import com.ort.edu.challengepractica.utils.Images


/**
 * El Fragment que representa la Home.
 * Implementa interfaz para manejar la selección de los productos de la lista
 * @see OnProductClickedListener
 */
class HomeFragment : Fragment(), OnProductClickedListener {
    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var productList: List<Product>
    private lateinit var title: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsRecyclerView = view.findViewById(R.id.product_recyclerview)
        title = view.findViewById(R.id.home_title)

        // Pongo el nombre del usuario en el titulo.
        // Advertencia: Al momento de mostrar un texto al usuario siempre usar un String resource. Nunca hardcodear de
        // esta manera.
        title.text = "Hola, ${UserSession.userName}"
        fillProductList()
    }

    /**
     * Cargo los productos que voy a usar para mostrar en la lista de la home
     */
    private fun fillProductList() {
        val product1 = Product("Google Pixel 5", Images.pixel, 70000.0)
        val product2 = Product("Remera estampada", Images.remera, 1500.0)
        val product3 = Product("Zapatillas nike", Images.zapatillas, 25000.0)
        val product4 = Product("Heladera no frost", Images.heladera, 80000.0)
        val product5 = Product("PC Gamer", Images.pcGamer, 150000.0)
        val product6 = Product("Campera invierno", Images.camperaInvierno, 30000.0)

        // Lleno una lista con productos que cree a mano
        productList = listOf(product1, product2, product3, product4, product5, product6)

        // Configuro el recyclerview y le paso un Adapter
        val layoutManager = LinearLayoutManager(context)
        productsRecyclerView.layoutManager = layoutManager
        productsRecyclerView.adapter = ProductAdapter(productList, this)
    }

    /**
     * Como esta clase implementa OnProductClickedListener, entonces tengo que implementar este metodo, donde voy
     * a navegar hacia el fragemnt de detalle de producto pasando como argumento el producto que seleccione
     * @param product Producto seleccionado de la lista
     */
    override fun onProductSelected(product: Product) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(product))
    }
}