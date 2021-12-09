package com.example.medinahotel

class ModelHotel {

    var uid:String = ""
    var id:String = ""
    var article:String = ""
    var description:String = ""
    var size:String = ""
    var barcode:String = ""
    var category:String = ""
    var categoryId:String = ""
    var url:String = ""
    var timestamp:Long = 0
    var viewsCount:Long = 0
    var downloadsCount:Long = 0


    constructor()
    constructor(
        uid: String,
        id: String,
        article: String,
        description: String,
        size: String,
        barcode: String,
        category: String,
        categoryId: String,
        url: String,
        timestamp: Long,
        viewsCount: Long,
        downloadsCount: Long
    ) {
        this.uid = uid
        this.id = id
        this.article = article
        this.description = description
        this.size = size
        this.barcode = barcode
        this.category = category
        this.categoryId = categoryId
        this.url = url
        this.timestamp = timestamp
        this.viewsCount = viewsCount
        this.downloadsCount = downloadsCount
    }


}