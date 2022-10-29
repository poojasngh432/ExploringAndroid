package com.poojasingh.exploringandroid.di

import javax.inject.Inject
import javax.inject.Named

/**
 * @Inject tells whenever you need an object of UserRegistrationService, you can call its constructor and get it
 * but then dagger sees there are two dependencies in the constructor
 * so now to get these objects we will call @Inject constructor annotation in these classes too
 */

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier private val notificationService: NotificationService //yha btana pdega ki msg ya email konsa wala Qualifier chahiye in NotificationServiceModule
    ) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send("receipient@gmail.com", email, "hi")
    }
}