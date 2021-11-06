package com.ahkam.start.data.repository.item.datasource

import com.ahkam.start.data.model.Item
import retrofit2.Response

interface ItemRemoteDataSource {
    suspend fun getItems(): Response<Item>
}