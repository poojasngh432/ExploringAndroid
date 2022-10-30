package com.poojasingh.exploringandroid.di.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poojasingh.exploringandroid.di.daggermvvm.models.Product

@Dao
interface FakerDAO {

    //database related tasks happen in bg so we'll use suspend
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(product: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>
}