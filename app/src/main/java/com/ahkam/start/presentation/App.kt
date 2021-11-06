package com.ahkam.start.presentation

import android.app.Application
import com.ahkam.start.presentation.di.Injector
import com.ahkam.start.presentation.di.core.*
import com.ahkam.start.presentation.di.item.ItemSubComponent
import com.ahkam.start.utils.Constant.BASE_URL


class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }


    override fun createItemSubComponent(): ItemSubComponent {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
        return appComponent.itemSubComponent().create()
    }



}