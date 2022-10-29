package com.poojasingh.exploringandroid.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {

    @Singleton
    @Provides
    fun getAnalyticsService() : AnalyticsService {
        return MixPanel()
    }
}