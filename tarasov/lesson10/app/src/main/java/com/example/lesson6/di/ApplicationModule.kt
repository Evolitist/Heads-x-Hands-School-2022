package com.example.lesson6.di

import android.content.Context
import androidx.room.Room
import com.example.lesson6.data.db.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule  {

    @Provides
    fun provideNoteDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "note_data_base"
    ).build()

    @Singleton
    @Provides
    fun provideNoteDao(dataBase: NoteDataBase) = dataBase.dao()

}