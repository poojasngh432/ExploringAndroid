package com.poojasingh.exploringandroid.di

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * this is now Loosely coupled
 */

interface UserRepository {
    fun saveUser(email: String, password: String)
}

@ActivityScope
class SQLRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("TEST", "User saved in DB")
        analyticsService.trackEvent("Save User", "create")
    }
}

class FirebaseRepository(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("TEST", "User saved in Firebase")
        analyticsService.trackEvent("Save User", "create")
    }
}