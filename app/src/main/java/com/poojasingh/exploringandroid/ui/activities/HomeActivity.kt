package com.poojasingh.exploringandroid.ui.activities

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.poojasingh.exploringandroid.R
import com.poojasingh.exploringandroid.databinding.ActivityHomeBinding
import com.poojasingh.exploringandroid.di.daggermvvm.DaggerActivity
import com.poojasingh.exploringandroid.utils.Constants
import com.poojasingh.exploringandroid.utils.create

class HomeActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private var btnViews = arrayListOf<View>()
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val TAG: String = HomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setNavDrawer()

        setButtons()
    }

    private fun setButtons() {
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

    private fun setNavDrawer() {
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle.drawerArrowDrawable.color = Color.WHITE
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_logout -> {
                    Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_about -> {
                    Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            btnViews[0] -> DIActivity.start(this@HomeActivity, Constants.EMAIL, Constants.PASSWORD)
            btnViews[1] -> DaggerActivity.start(this@HomeActivity)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navView)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbarContainer.toolbar)
        supportActionBar?.run {
            configureToolbarTitle()
        }
    }

    private fun configureToolbarTitle() {
        supportActionBar?.title = getString(R.string.main_screen)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        btnViews.clear()
        binding.root.removeAllViews()
    }
}