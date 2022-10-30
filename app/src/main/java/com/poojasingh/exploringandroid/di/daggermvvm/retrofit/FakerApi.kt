package com.poojasingh.exploringandroid.di.daggermvvm.retrofit

import com.poojasingh.exploringandroid.di.daggermvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}