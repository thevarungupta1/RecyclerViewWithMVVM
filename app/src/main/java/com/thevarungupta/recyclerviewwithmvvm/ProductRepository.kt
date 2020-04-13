package com.thevarungupta.recyclerviewwithmvvm

import retrofit2.Call


class ProductRepository(
    private val api: ProductsApi
) {

    //fun getProducts() = api.getProducts()

    fun getProducts(): Call<ProductResponse> {
        return api.getProducts()
    }

}