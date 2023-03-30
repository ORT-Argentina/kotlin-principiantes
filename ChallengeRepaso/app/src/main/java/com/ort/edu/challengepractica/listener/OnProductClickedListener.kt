package com.ort.edu.challengepractica.listener

import com.ort.edu.challengepractica.model.Product

/**
 * Esta interfaz sera utilizada para ser implementada cuando se quiera manejar la seleccion de un producto en una clase
 */
interface OnProductClickedListener {

    /**
     * Se invoca cuando se selecciona un produOnProductClickedListener cto de la lista
     */
    fun onProductSelected(product: Product)
}