package com.poojasingh.exploringandroid.di.daggermvvm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.poojasingh.exploringandroid.BaseApplication
import com.poojasingh.exploringandroid.databinding.ActivityDaggerBinding
import com.poojasingh.exploringandroid.di.daggermvvm.retrofit.FakerApi
import com.poojasingh.exploringandroid.di.daggermvvm.viewmodels.DaggerViewmodel
import com.poojasingh.exploringandroid.di.daggermvvm.viewmodels.DaggerViewmodelFactory
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaggerBinding

    lateinit var daggerViewmodel: DaggerViewmodel

    @Inject
    lateinit var daggerViewModelFactory: DaggerViewmodelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaggerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as BaseApplication).applicationComponent.inject(this)

        daggerViewmodel = ViewModelProvider(this, daggerViewModelFactory)[DaggerViewmodel::class.java]

        daggerViewmodel.productsLiveData.observe(this, Observer {
            binding.products.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }

    companion object {
        @JvmStatic
        fun start(activity: Activity) {
            val intent = Intent(activity, DaggerActivity::class.java)
            intent.apply {
                activity.startActivity(intent)
            }
        }
    }
}