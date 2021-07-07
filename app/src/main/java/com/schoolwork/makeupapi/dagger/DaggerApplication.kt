package com.schoolwork.makeupapi.dagger

import android.app.Application

class DaggerApplication: Application() {

    lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent
            .builder()
            .retrofitInstanceModule(RetrofitInstanceModule())
            .build()
    }
}