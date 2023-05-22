package com.ort.edu.mvvmexample.domain

import com.ort.edu.mvvmexample.data.QuoteRepository
import com.ort.edu.mvvmexample.data.model.QuoteModel
import com.ort.edu.mvvmexample.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}