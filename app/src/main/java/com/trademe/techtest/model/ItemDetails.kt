package com.trademe.techtest.model

data class ItemDetails(var name: String,
                       var location:String,
                       var price: Double,
                       var imageUrl: String) {
    var buyNowPrice: Double? = null
    var isClassified = false
}
