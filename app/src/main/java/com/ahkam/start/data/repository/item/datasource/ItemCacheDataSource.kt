package com.ahkam.start.data.repository.item.datasource

import com.ahkam.start.data.model.Item

interface ItemCacheDataSource {
    suspend fun getItemsFromCache():List<Item.Results>
    suspend fun saveItemsFromCache(item: List<Item.Results>)
}