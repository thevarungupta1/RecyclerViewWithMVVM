package com.thevarungupta.recyclerviewwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var factory: ProductViewModelFactory
    lateinit var viewModel: ProductViewModel
    lateinit var adapterProduct: AdapterProduct

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //var viewModel = ViewModelProviders.of(this).get(ProductViewModel)
        var api = ProductsApi()
        var repository = ProductRepository(api)
        factory = ProductViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(ProductViewModel::class.java)
        viewModel.getProducts()

        viewModel.products.observe(this, Observer {products ->
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter = AdapterProduct(this, products)
//            recycler_view.also {
//                it.layoutManager = LinearLayoutManager(applicationContext)
//                it.adapter = AdapterProduct(products)
//            }

        })









    }
}
