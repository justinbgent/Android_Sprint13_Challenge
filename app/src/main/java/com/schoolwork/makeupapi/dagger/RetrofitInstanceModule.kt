package com.schoolwork.makeupapi.dagger

import com.schoolwork.makeupapi.retrofit.RetrofitInstance
import dagger.Module
import dagger.Provides

@Module
class RetrofitInstanceModule {
    @Provides
    fun provideRetroInstance(): RetrofitInstance{
        return RetrofitInstance()
    }
}