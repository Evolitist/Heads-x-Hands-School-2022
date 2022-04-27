package com.example.hw7

import android.app.Application
import com.example.hw7.domain.NanoPostApiService
import com.squareup.moshi.Moshi
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@HiltAndroidApp
class App : Application() {
//    companion object {
//        lateinit var instance: App
//    }

//    override fun onCreate() {
//        super.onCreate()
//        instance = this
//    }

//    private val moshi: Moshi by lazy {
//        Moshi.Builder().build()
//    }
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://nanopost.evolitist.com/api/v1/")
//        .addConverterFactory(MoshiConverterFactory.create())
//        .build()
//   val apiService = retrofit.create<NanoPostApiService>()
}