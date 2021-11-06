package com.ahkam.start.presentation.di.item

import com.ahkam.start.module.listings.fragment.HomeFragment
import dagger.Subcomponent

@ItemScope
@Subcomponent(modules = [ItemModule::class])
interface ItemSubComponent {
    fun inject (homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():ItemSubComponent
    }
}