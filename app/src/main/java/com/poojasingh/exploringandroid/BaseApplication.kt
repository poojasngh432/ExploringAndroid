package com.poojasingh.exploringandroid

import android.app.Application
import com.poojasingh.exploringandroid.di.AppComponent
import com.poojasingh.exploringandroid.di.DaggerAppComponent
import com.poojasingh.exploringandroid.di.daggermvvm.dagger.ApplicationComponent
import com.poojasingh.exploringandroid.di.daggermvvm.dagger.DaggerApplicationComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}