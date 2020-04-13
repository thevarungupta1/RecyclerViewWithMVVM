package com.thevarungupta.recyclerviewwithmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(
    private val respository: ProductRepository
) : ViewModel(){

    val products = MutableLiveData<List<Product>>()

    fun getProducts(){
        respository.getProducts().enqueue(object: Callback<ProductResponse>{
            override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {

            }

            override fun onResponse(
                call: Call<ProductResponse>?,
                response: Response<ProductResponse>?
            ) {
                products.value = response?.body()?.data
            }

        })
    }

}