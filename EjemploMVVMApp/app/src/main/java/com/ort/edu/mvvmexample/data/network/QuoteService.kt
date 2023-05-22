package com.ort.edu.mvvmexample.data.network

import com.ort.edu.mvvmexample.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val service:QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}