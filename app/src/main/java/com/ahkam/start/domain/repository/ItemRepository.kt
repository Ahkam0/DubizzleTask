package com.ahkam.start.domain.repository

import com.ahkam.start.data.model.Item

interface ItemRepository {

    suspend fun getItems():List<Item.Results>?
}