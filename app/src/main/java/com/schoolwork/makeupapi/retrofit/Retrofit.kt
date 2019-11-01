package com.schoolwork.makeupapi.retrofit

import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class MakeupProduct(val name: String, val price: String, val image_link: String, val rating: String?)


interface MakeupApi{
    @GET("products.json")
    fun getProductList(@Query("brand")brand: String): Single<Array<MakeupProduct>>
}

object Retrofit {
    const val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"

    fun getProducts(brand: String): Single<Array<MakeupProduct>>{
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MakeupApi::class.java)

        return builder.getProductList(brand)
    }


}