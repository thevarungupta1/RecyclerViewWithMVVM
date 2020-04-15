package com.thevarungupta.recyclerviewwithmvvm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.thevarungupta.recyclerviewwithmvvm.databinding.RowProductAdapterBinding


class AdapterProduct(private var mContext: Context, private var mList: List<Product>) :
    RecyclerView.Adapter<AdapterProduct.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = DataBindingUtil.inflate<RowProductAdapterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_product_adapter,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mBinding.product = mList[position]
        holder.mBinding.root.setOnClickListener {

        }

        holder.mBinding.buttonSubmit.setOnClickListener {
            // write code
            var product = mList.get(position)
            var intent = Intent(mContext, ProductDetailActivity::class.java)
            intent.putExtra(Product.KEY, product)
            mContext.startActivity(intent)

        }
    }

    inner class MyViewHolder(
        var mBinding: RowProductAdapterBinding
    ) : RecyclerView.ViewHolder(mBinding.root)
}