package com.schoolwork.makeupapi.dagger

import com.schoolwork.makeupapi.MainActivity
import dagger.Component

@Component(modules = [RetrofitInstanceModule::class])
interface RetroComponent {
    fun inject(mainActivity: MainActivity)
}