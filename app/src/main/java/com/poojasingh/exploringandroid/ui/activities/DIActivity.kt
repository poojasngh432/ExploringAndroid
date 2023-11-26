package com.poojasingh.exploringandroid.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poojasingh.exploringandroid.BaseApplication
import com.poojasingh.exploringandroid.databinding.ActivityDiactivityBinding
import com.poojasingh.exploringandroid.di.*
import com.poojasingh.exploringandroid.utils.Constants
import javax.inject.Inject

class DIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiactivityBinding
      //Field Injection for Method 2
    lateinit var userRegistrationService2: UserRegistrationService @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appComponent = (application as BaseApplication).appComponent
        val userRegistrationComponent = appComponent.getUserRegistrationComponent()


        //Method 1 - when @Inject is used with constructor - Constructor Injection
        val userRegistrationService = userRegistrationComponent.getUserRegistrationService()
        userRegistrationService.registerUser("pooja@gmail.com", "1111")
        val emailService = userRegistrationComponent.getEmailService()
        //we can access any object we want using component

        //Method 2 - we are passing consumer here which is DIActivity. jin jin fields par @Inject lga hua h voh component provide krdega
        // when @Inject is used to tell component which fields to provide
        userRegistrationComponent.inject(this)
        userRegistrationService2.registerUser("pooja@gmail.com", "1111")
    }

    companion object {
        @JvmStatic
        fun start(activity: Activity, email: String, password: String) {
            val intent = Intent(activity, DIActivity::class.java)
            val bundle = Bundle()
            bundle.putString(Constants.Values.EMAIL, email)
            bundle.putString(Constants.Values.PASSWORD, password)
            intent.apply {
                putExtras(bundle)
                activity.startActivity(intent)
            }
        }
    }
}