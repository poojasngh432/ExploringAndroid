package com.poojasingh.exploringandroid.di.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poojasingh.exploringandroid.di.daggermvvm.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO
}