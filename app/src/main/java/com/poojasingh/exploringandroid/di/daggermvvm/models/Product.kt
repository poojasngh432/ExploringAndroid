package com.poojasingh.exploringandroid.di.daggermvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity - table fr Room db

@Entity
data class Product (
    val category: String? = null,
    val description: String? = null,
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val image: String? = null,
    val price: Double? = null,
    val title: String? = null
)