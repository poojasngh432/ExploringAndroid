package com.poojasingh.exploringandroid.di

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * jo bhi dynamic values hongi voh yha class constructor me as a parameter bhi bhej skte h but component bnate time add krna hoga and vha dynamic value bhejni hogi jo yha access ho paegi
 * second method to do the same is Factory
 */
@Module
class NotificationServiceModule() {

    //jab bhi UserRepository ki requirement ayegi, ye method object provide krega
    //jo component me integer value pdi h dagger voh pass krdega
    @ActivityScope
    @MessageQualifier
    @Provides
    fun getMessageService() : NotificationService {
        return MessageService(3)
    }

    //Qualifiers(@Named) are used for this scenario when there are two methods that return NotificationService
    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService) : NotificationService {
        return emailService
    }
}