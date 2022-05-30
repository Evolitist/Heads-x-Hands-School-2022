package com.example.lesson6.di

import com.example.lesson6.data.NoteRepository
import com.example.lesson6.data.NoteRepositoryImpl
import com.example.lesson6.data.RoomDataSource
import com.example.lesson6.data.db.NoteDataBase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository
}