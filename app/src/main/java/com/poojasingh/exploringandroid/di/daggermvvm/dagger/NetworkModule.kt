package com.poojasingh.exploringandroid.di.daggermvvm.dagger

import com.poojasingh.exploringandroid.di.daggermvvm.retrofit.FakerApi
import com.poojasingh.exploringandroid.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//jitne bhi hmare @Provides methods honge, hm is module k andar likhenge
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit) : FakerApi {
        return retrofit.create(FakerApi::class.java)
    }
}