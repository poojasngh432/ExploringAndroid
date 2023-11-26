package com.poojasingh.exploringandroid.di.daggermvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

//ViewmodelFactory ko hm generalise krenge through Multiple Binding
class DaggerViewmodelFactory @Inject constructor(
    private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>
    ): ViewModelProvider.Factory {

    //activity me factory se model bnate waqt hm viewmodel ka type bhejte h vhi yha modelClass me ata h
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}

/*
class DaggerViewmodelFactory @Inject constructor(private val daggerViewmodel: DaggerViewmodel): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return daggerViewmodel as T
    }
}*/
