package com.poojasingh.exploringandroid.di.daggermvvm.dagger

import android.content.Context
import androidx.room.Room
import com.poojasingh.exploringandroid.di.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesFakerDB(context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }
}