package com.dilah.muslim_media_app.model.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


// using object for creating single instance
// for making request
object ApiClient {
    fun provideApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader("X-API-KEY", "5496eea90ef04435ae998fca418aa203")
                    .build()
                it.proceed(newRequest)
        }
            .readTimeout(10, TimeUnit.SECONDS) //time to wait for the response to the API
            .retryOnConnectionFailure(false)
            .build() //save the detail request

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    }
}