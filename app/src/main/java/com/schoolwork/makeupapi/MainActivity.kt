package com.schoolwork.makeupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.schoolwork.makeupapi.dagger.DaggerApplication
import com.schoolwork.makeupapi.retrofit.MakeupProduct
import com.schoolwork.makeupapi.retrofit.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var retroInstance: RetrofitInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = (application as DaggerApplication).retroComponent
        component.inject(this)

        btn_search.setOnClickListener {
            retroInstance.getProducts(edit_txt.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { arrayOf(MakeupProduct("InvalidBrand", "InvalidBrand", "", "InvalidBrand")) }
                .subscribe{ products -> setupRecyclerView(products)}
        }
    }

    private fun setupRecyclerView(productsList: Array<MakeupProduct>){
        makeup_recycler.adapter = RecyclerViewAdapter(productsList)
    }
}
