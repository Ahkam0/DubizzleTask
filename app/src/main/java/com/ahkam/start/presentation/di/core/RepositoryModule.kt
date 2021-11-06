package com.ahkam.start.presentation.di.core

import com.ahkam.start.data.repository.item.ItemRepositoryImpl
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.start.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideItemRepository(
        itemRemoteDataSource: ItemRemoteDataSource,
        itemCacheDataSource: ItemCacheDataSource
    ):ItemRepository
    {
        return ItemRepositoryImpl(itemRemoteDataSource,itemCacheDataSource)
    }



}