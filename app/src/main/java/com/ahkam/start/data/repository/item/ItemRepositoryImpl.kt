package com.ahkam.start.data.repository.item

import android.util.Log
import com.ahkam.start.data.model.Item
import com.ahkam.start.data.repository.item.datasource.ItemCacheDataSource
import com.ahkam.start.data.repository.item.datasource.ItemRemoteDataSource
import com.ahkam.start.domain.repository.ItemRepository
import retrofit2.Response
import java.lang.Exception

class ItemRepositoryImpl (
    private val itemRemoteDataSource: ItemRemoteDataSource,
    private val itemCacheDataSource: ItemCacheDataSource
): ItemRepository {
    override suspend fun getItems(): List<Item.Results> {
        return getItemsFromCache()
    }

    suspend fun getItemsFromAPI():List<Item.Results>
    {
        lateinit var itemsList: List<Item.Results>

        itemsList = emptyList()

        try{
            val response : Response<Item> = itemRemoteDataSource.getItems()
            val body:Item = response.body()!!

            body.results?.let {
                itemsList = it

            }


        }catch (exception:Exception)
        {
            Log.i("MyTag----",exception.message.toString())
        }

        return itemsList
    }


    suspend fun getItemsFromCache():List<Item.Results>
    {
        lateinit var itemsList: List<Item.Results>
        try{
            itemsList = itemCacheDataSource.getItemsFromCache()

        }catch (exception:Exception)
        {
            Log.i("MyTag",exception.message.toString())
        }

        if(itemsList.size>0)
        {
            return itemsList
        }else{
            itemsList = getItemsFromAPI()
            itemCacheDataSource.saveItemsFromCache(itemsList)
        }

        return itemsList

    }

}