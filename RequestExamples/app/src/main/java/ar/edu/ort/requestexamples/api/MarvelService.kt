package ar.edu.ort.requestexamples.api

import androidx.core.content.ContentProviderCompat.requireContext
import ar.edu.ort.requestexamples.R
import ar.edu.ort.requestexamples.interfaces.marvelAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelService {

    companion object {
        private const val BASE_URL = ""

        fun create( baseURL: String): marvelAPI {
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
        }
    }
}