package com.ahkam.start.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Item :Serializable {
    var image: String = ""
    var itemId: String = ""
    var name: String = ""
    var priceGRAM: String = ""
    var priceKG: String = ""
    var urduName: String = ""


    var results: List<Results>? = null
    var pagination: Pagination? = null

    inner class Results : Serializable {

        var created_at: String? = null
        var price: String? = null
        var name: String? = null
        var uid: String? = null
        var image_ids: List<String>? = null
        var image_urls: List<String>? = null
        var image_urls_thumbnails: List<String>? = null
    }


    inner class Pagination : Serializable {
        var key: String? = null
    }

}