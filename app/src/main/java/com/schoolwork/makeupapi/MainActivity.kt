package com.schoolwork.makeupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.schoolwork.makeupapi.retrofit.MakeupProduct
import com.schoolwork.makeupapi.vm.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainActivityViewModel()

        btn_search.setOnClickListener {
            viewModel.getProducts(edit_txt.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { arrayOf(MakeupProduct("InvalidBrand", "InvalidBrand", "", "InvalidBrand")) }
                .subscribe{ products -> setupRecyclerView(products)}
        }
    }

    fun setupRecyclerView(productsList: Array<MakeupProduct>){
        //val manger = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //makeup_recycler.layoutManager = manger
        makeup_recycler.adapter = RecyclerViewAdapter(productsList)
    }
}
