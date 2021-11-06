package com.ahkam.start.domain.usecase

import com.ahkam.start.data.model.Item
import com.ahkam.start.domain.repository.ItemRepository

class GetItemsUseCase(private val itemRepository: ItemRepository) {

    suspend fun execute():List<Item.Results>?=itemRepository.getItems()
}