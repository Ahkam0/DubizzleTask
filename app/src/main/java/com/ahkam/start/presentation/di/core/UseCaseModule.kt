package com.ahkam.start.presentation.di.core

import com.ahkam.start.domain.repository.ItemRepository
import com.ahkam.start.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetItemUseCase(itemRepository: ItemRepository):GetItemsUseCase
    {
        return GetItemsUseCase(itemRepository)
    }


}