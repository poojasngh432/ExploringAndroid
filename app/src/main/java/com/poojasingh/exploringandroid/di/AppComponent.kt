package com.poojasingh.exploringandroid.di

import dagger.Component
import javax.inject.Singleton

//we'll use this to define component on application level
//simple component that provides AnalyticsService object
//AppComponent is parent component & UserRegistrationComponent is subcomponent
@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {

    fun getUserRegistrationComponent() : UserRegistrationComponent
}