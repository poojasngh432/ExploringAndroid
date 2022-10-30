package com.poojasingh.exploringandroid.di.daggermvvm.dagger

import com.poojasingh.exploringandroid.di.daggermvvm.DaggerActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(daggerActivity: DaggerActivity)
}