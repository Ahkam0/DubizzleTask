package com.ahkam.start.presentation.di.item

import com.ahkam.start.domain.usecase.GetItemsUseCase
import com.ahkam.start.presentation.item.ItemViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ItemModule {

    @ItemScope
    @Provides
    fun provideItemViewModelFactory(
        getItemsUseCase: GetItemsUseCase
    ): ItemViewModelFactory{

        return ItemViewModelFactory(getItemsUseCase)
    }

}