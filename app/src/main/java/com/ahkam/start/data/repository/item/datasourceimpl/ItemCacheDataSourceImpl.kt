package com.ahkam.start.data.repository.item.datasourceimpl

import com.ahkam.start.data.model.Item
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource

class ItemCacheDataSourceImpl : ItemCacheDataSource {
    private var itemsList = ArrayList<Item.Results>()
    override suspend fun getItemsFromCache(): List<Item.Results> {
        return itemsList
    }

    override suspend fun saveItemsFromCache(item: List<Item.Results>) {
        itemsList.clear()
        itemsList = ArrayList(item)

    }
}