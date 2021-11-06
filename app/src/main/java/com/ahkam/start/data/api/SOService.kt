package com.ahkam.start.data.api

import com.ahkam.start.data.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface SOService {

    @GET("default/dynamodb-writer")
    suspend fun getItemList():Response<Item>

}