package ort.tp3.cars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import ort.tp3.cars.commons.Config
import ort.tp3.cars.interceptors.RequestInterceptor
import ort.tp3.cars.data.network.CarsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private var client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(RequestInterceptor)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesCarsApiClient(retrofit: Retrofit): CarsApi {
        return retrofit.create(CarsApi::class.java)
    }
}