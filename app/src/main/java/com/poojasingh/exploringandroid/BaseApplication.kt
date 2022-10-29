package com.poojasingh.exploringandroid

import android.app.Application
import com.poojasingh.exploringandroid.di.AppComponent
import com.poojasingh.exploringandroid.di.DaggerAppComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}