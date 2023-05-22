package com.ort.edu.mvvmexample.domain

import com.ort.edu.mvvmexample.data.QuoteRepository
import com.ort.edu.mvvmexample.data.database.entities.toDatabase
import com.ort.edu.mvvmexample.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            //Elimino los registros para hacer una nueva inserción
            //repository.clearQuotes()

            //Inserto los nuevos registros
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}