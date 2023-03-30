package ar.edu.ort.requestexamples.api

import ar.edu.ort.requestexamples.interfaces.facebookAPI
import ar.edu.ort.requestexamples.interfaces.marvelAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelService {

    companion object {

        fun create( baseURL: String ): marvelAPI {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(marvelAPI::class.java)
                //.create(facebookAPI::class.java)

        }
    }
}