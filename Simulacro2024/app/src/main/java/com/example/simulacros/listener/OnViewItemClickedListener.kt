package com.example.simulacros.listener

import com.example.simulacros.domain.model.Dog

interface OnViewItemClickedListener {
    fun onViewItemDetail(dog: Dog)
}