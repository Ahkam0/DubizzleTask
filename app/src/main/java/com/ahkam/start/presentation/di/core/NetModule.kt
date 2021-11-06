package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.api.SOService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule (private val baseURL:String){

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseURL).build()
    }

    @Singleton
    @Provides
    fun provideSOService(retrofit: Retrofit) : SOService {
        return retrofit.create(SOService::class.java)
    }

}