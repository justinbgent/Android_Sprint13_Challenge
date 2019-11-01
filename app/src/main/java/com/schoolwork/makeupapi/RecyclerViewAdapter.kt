package com.schoolwork.makeupapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.schoolwork.makeupapi.retrofit.MakeupProduct
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerViewAdapter(val productList: Array<MakeupProduct>): RecyclerView.Adapter<RecyclerViewAdapter.MakeupViewHolder>() {
    class MakeupViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val productName: TextView = view.txt_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MakeupViewHolder(view)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: MakeupViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
    }
}