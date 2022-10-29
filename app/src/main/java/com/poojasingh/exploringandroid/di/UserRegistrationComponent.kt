package com.poojasingh.exploringandroid.di

import com.poojasingh.exploringandroid.ui.activities.DIActivity
import dagger.BindsInstance
import dagger.Subcomponent

//Activity Level component
//sub-component wo sare objects use krskta h jo uska parent provide krta h, hme un objects ko explicitly nhi define krna pdega, we can directly use them
//to hm userRegistrationComponent ko app component ka sub-component bna denge
@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

    fun getUserRegistrationService() : UserRegistrationService

    fun getEmailService() : EmailService

    //method 2 - either above methods or this
    //diActivity is Consumer
    fun inject(diActivity: DIActivity)

    //we are telling dagger that whenever you build component, use Factory. Factory MainApplicationComponent ka object bna ke degi
    //Factory hmne isliye define kri thi kyuki hme runtime pr isme values pass krni thi
    //method to use dynamic values in creating an obj
    //Factory dependency component ko create krti h
    /*@Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent
    }*/
}