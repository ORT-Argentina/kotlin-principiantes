package com.ort.edu.mvvmexample.domain.model

import com.ort.edu.mvvmexample.data.database.entities.QuoteEntity
import com.ort.edu.mvvmexample.data.model.QuoteModel

data class Quote (
    val quote:String,
    val author:String,
    val category:String
)

fun QuoteModel.toDomain() = Quote(quote, author, category)
fun QuoteEntity.toDomain() = Quote(quote, author, category)