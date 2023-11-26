package com.poojasingh.exploringandroid.di.daggermvvm.dagger

import androidx.lifecycle.ViewModel
import com.poojasingh.exploringandroid.di.daggermvvm.viewmodels.DaggerViewmodel
import com.poojasingh.exploringandroid.di.daggermvvm.viewmodels.DaggerViewmodel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(DaggerViewmodel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: DaggerViewmodel) : ViewModel

    @Binds
    @ClassKey(DaggerViewmodel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: DaggerViewmodel2) : ViewModel
}