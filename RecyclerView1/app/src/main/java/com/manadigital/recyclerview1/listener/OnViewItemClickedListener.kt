package com.manadigital.recyclerview1.listener

import com.manadigital.recyclerview1.entities.Contacto

interface OnViewItemClickedListener {
    fun onViewItemDetail(contacto: Contacto)
}