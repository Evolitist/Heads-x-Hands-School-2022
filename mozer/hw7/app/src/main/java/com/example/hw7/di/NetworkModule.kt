package com.example.hw7.di

import com.example.hw7.domain.NanoPostApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideMRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://nanopost.evolitist.com/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): NanoPostApiService{
        return retrofit.create()
    }
}