package com.ahkam.start.data.repository.item.datasourceimpl

import com.ahkam.start.data.api.SOService
import com.ahkam.start.data.model.Item
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import retrofit2.Response

class ItemRemoteDataSourceImpl(private val soService: SOService):
    ItemRemoteDataSource {
    override suspend fun getItems(): Response<Item> = soService.getItemList()

}