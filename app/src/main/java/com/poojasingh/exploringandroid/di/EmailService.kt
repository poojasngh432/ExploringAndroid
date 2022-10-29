package com.poojasingh.exploringandroid.di

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * this is now Loosely coupled
 */

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("TEST", "Email sent")
    }
}

class MessageService(private val retryCount: Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("TEST", "Message sent - Retry count $retryCount")
    }
}