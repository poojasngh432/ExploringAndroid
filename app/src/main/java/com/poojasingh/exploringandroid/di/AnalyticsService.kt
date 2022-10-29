package com.poojasingh.exploringandroid.di

import android.util.Log

interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

class MixPanel : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("TEST", "Mixpanel - $eventName - $eventType")
    }
}

class FirebaseAnalytics : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("TEST", "FirebaseAnalytics - $eventName - $eventType")
    }
}