package com.poojasingh.exploringandroid.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poojasingh.exploringandroid.R
import com.poojasingh.exploringandroid.databinding.ActivityTemplateBinding

/**
 * Template activity to copy common code from
 */

class TemplateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarContainer.toolbar)
        supportActionBar?.run {
            configureToolbarTitle()
//            setDisplayHomeAsUpEnabled(true)
//            setHomeButtonEnabled(true) - shows a back button arrow on top left
        }
    }

    private fun configureToolbarTitle() {
        supportActionBar?.title = getString(R.string.main_screen)
    }
}