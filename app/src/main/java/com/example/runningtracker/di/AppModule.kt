package com.example.runningtracker.di

import android.content.Context
import androidx.room.Room
import com.example.runningtracker.db.RunningDatabase
import com.example.runningtracker.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app, RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

}