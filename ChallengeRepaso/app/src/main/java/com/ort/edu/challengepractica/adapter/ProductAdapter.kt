package com.ort.edu.challengepractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.challengepractica.R
import com.ort.edu.challengepractica.listener.OnProductClickedListener
import com.ort.edu.challengepractica.model.Product

/**
 * Adapter para los productos que se muestran en la Home.
 * @param productList La lista de productos que vamos a mostrar
 * @param onProductClickedListener listener al cual se va a invocar cada vez que se seleccione un producto de la lista
 */
class ProductAdapter(
    private val productList: List<Product>,
    private val onProductClickedListener: OnProductClickedListener
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // De la lista, obtengo el producto basandome en la posicion de la celda en el recyclerview
        val product = productList[position]

        // Se invoca al ViewHolder para que muestre los datos del producto
        holder.bind(product)

        // Establezco un click listener en el itemview del holder. Esto seria, la vista entera del elemento {position}
        // de la lista
        holder.itemView.setOnClickListener {
            onProductClickedListener.onProductSelected(product)
        }
    }

    override fun getItemCount() = productList.size
}