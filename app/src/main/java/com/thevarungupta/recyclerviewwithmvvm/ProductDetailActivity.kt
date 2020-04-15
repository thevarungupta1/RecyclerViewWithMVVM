package com.thevarungupta.recyclerviewwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.thevarungupta.recyclerviewwithmvvm.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    lateinit var product: Product
    lateinit var mBinding : ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)

        product =  intent.getSerializableExtra(Product.KEY) as Product

        mBinding.productInfo = product


    }
}
