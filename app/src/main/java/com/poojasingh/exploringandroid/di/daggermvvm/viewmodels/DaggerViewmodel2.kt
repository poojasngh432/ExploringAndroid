package com.poojasingh.exploringandroid.di.daggermvvm.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DaggerViewmodel2 @Inject constructor(private  val randomize: Randomize) : ViewModel() {

    init {
        randomize.doAction()
    }
}