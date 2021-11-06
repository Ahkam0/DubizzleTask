package com.ahkam.start.presentation.di


import com.ahkam.start.presentation.di.item.ItemSubComponent

interface Injector {
    fun createItemSubComponent(): ItemSubComponent


}