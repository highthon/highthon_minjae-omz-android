package com.minjae.highthon.di.module

import android.content.Context
import androidx.room.Room
import com.minjae.highthon.data.local.dao.OmzDao
import com.minjae.highthon.data.local.database.OmzDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideJunctionDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): OmzDatabase = Room
        .databaseBuilder(context, OmzDatabase::class.java, "JunctionDataBase")
        .build()

    @Provides
    fun provideJoticeDao(
        omzDatabase: OmzDatabase
    ): OmzDao = omzDatabase.omzDao()
}
