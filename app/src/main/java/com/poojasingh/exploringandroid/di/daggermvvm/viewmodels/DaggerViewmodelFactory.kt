package com.poojasingh.exploringandroid.di.daggermvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poojasingh.exploringandroid.di.daggermvvm.repository.ProductRepository
import javax.inject.Inject

class DaggerViewmodelFactory @Inject constructor(private val repository: ProductRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DaggerViewmodel(repository) as T
    }
}