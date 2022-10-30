package com.poojasingh.exploringandroid.di.daggermvvm.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojasingh.exploringandroid.di.daggermvvm.models.Product
import com.poojasingh.exploringandroid.di.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DaggerViewmodel @Inject constructor(private val repository: ProductRepository,
                                          private val randomize: Randomize) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}

class Randomize @Inject constructor() {

    fun doAction() {
        Log.d("TESTING", "Random Action")
    }
}