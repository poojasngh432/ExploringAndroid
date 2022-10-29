package com.poojasingh.exploringandroid.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

    //jab bhi UserRepository ki requirement ayegi, ye method object provide krega
//    @Provides
//    fun getSQLRepository(sqlRepository: SQLRepository) : UserRepository {
//        return sqlRepository
//    }

    //binds UserRepository with SQLRepository. class UserRepositoryModule is also changed to abstract class
    @Binds
    @ActivityScope
    abstract fun getSQLRepository(sqlRepository: SQLRepository) : UserRepository
}