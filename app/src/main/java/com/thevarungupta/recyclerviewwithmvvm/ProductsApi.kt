package com.thevarungupta.recyclerviewwithmvvm

import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.thevarungupta.recyclerviewwithmvvm.app.Config
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductsApi {

    @GET("products/1")
    fun getProducts(): Call<ProductResponse>

    companion object {
        operator fun invoke(): ProductsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL)
                .build()
                .create(ProductsApi::class.java)
        }
    }

}