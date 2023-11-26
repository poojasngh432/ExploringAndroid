package com.poojasingh.exploringandroid.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ContentInfoCompat.Flags
import com.poojasingh.exploringandroid.BaseApplication
import com.poojasingh.exploringandroid.R
import com.poojasingh.exploringandroid.TemplateViewModel
import com.poojasingh.exploringandroid.TemplateViewModelFactory
import com.poojasingh.exploringandroid.databinding.ActivityTemplateBinding
import com.poojasingh.exploringandroid.di.daggermvvm.db.FakerDB
import com.poojasingh.exploringandroid.di.daggermvvm.models.Product
import com.poojasingh.exploringandroid.di.daggermvvm.repository.ProductRepository
import com.poojasingh.exploringandroid.di.daggermvvm.retrofit.FakerApi
import com.poojasingh.exploringandroid.utils.Constants
import javax.inject.Inject

/**
 * Template activity to copy common code from
 */

class TemplateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemplateBinding
    private val TAG: String = TemplateActivity::class.java.simpleName
    lateinit var templateViewModel: TemplateViewModel

    @Inject
    lateinit var templateViewModelFactory: TemplateViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        someFunction()

//        (application as BaseApplication).applicationComponent.inject(this)

    }

    private fun someFunction() {
        val intent: Intent? = Intent()
        intent?.let {
            it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        intent?.apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val res2 = intent?.run {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val result = with(intent) {
            this?.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    "RESULE"
        }

        val result2 = this.apply {
            actionBar?.title = "abc"
        }
        Toast.makeText(this, "$result2", Toast.LENGTH_LONG).show()
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

    override fun onDestroy() {
        super.onDestroy()
        binding.root.removeAllViews()
    }
}