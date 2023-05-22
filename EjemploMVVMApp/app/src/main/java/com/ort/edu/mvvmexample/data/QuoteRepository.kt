package com.ort.edu.mvvmexample.data

import com.ort.edu.mvvmexample.data.database.dao.QuoteDao
import com.ort.edu.mvvmexample.data.database.entities.QuoteEntity
import com.ort.edu.mvvmexample.data.model.QuoteModel
import com.ort.edu.mvvmexample.data.network.QuoteService
import com.ort.edu.mvvmexample.domain.model.Quote
import com.ort.edu.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val remote: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = remote.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}