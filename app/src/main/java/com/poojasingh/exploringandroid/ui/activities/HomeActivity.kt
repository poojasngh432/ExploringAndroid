package com.poojasingh.exploringandroid.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.poojasingh.exploringandroid.R
import com.poojasingh.exploringandroid.databinding.ActivityHomeBinding
import com.poojasingh.exploringandroid.di.daggermvvm.DaggerActivity
import com.poojasingh.exploringandroid.utils.AppConstants
import com.poojasingh.exploringandroid.utils.Constants
import com.poojasingh.exploringandroid.utils.create

class HomeActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private var btnViews = arrayListOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //start adding button
        addButton("DI")
        addButton("DaggerActivity")
        addButton("TESTING")
    }

    private fun addButton(btnName: String) {
        val buttonView = Button(this).create(btnName)
        buttonView.setOnClickListener(this)
        btnViews.add(buttonView)
        binding.container.addView(buttonView)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnViews[0] -> DIActivity.start(this@HomeActivity, Constants.EMAIL, Constants.PASSWORD)
            btnViews[1] -> DaggerActivity.start(this@HomeActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        btnViews.clear()
    }
}