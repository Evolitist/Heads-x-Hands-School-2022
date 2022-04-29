package com.example.hw7.di

import com.example.hw7.data.repository.PostRepositoryImpl
import com.example.hw7.data.repository.ProfileRepositoryImpl
import com.example.hw7.domain.repository.PostRepository
import com.example.hw7.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository
}