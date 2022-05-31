package com.example.nanopost.di

import com.example.nanopost.data.PrefsRepository
import com.example.nanopost.data.api.repository.ApiRepository
import com.example.nanopost.data.api.repository.AuthRepository
import com.example.nanopost.data.api.repository.impl.ApiRepositoryImpl
import com.example.nanopost.data.api.repository.impl.AuthRepositoryImpl
import com.example.nanopost.data.PrefsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(repositoryImpl: ApiRepositoryImpl) : ApiRepository

    @Binds
    abstract fun bindAuthRepository(repositoryImpl: AuthRepositoryImpl) : AuthRepository

    @Binds
    abstract fun bindPrefsRepository(repositoryImpl: PrefsRepositoryImpl) : PrefsRepository
}