package com.poojasingh.exploringandroid.di.daggermvvm.dagger

import android.content.Context
import androidx.lifecycle.ViewModel
import com.poojasingh.exploringandroid.di.daggermvvm.DaggerActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewmodelModule::class])
interface ApplicationComponent {

    fun inject(daggerActivity: DaggerActivity)

    fun getMap() : Map<Class<*>, ViewModel>

    //we created factory because we need something(context) in runtime in DatabaseModule class
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}