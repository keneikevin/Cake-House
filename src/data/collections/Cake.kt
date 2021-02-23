package com.kevin.data.collections

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Cake(
    val title:String,
    val size:Long,
    val price:Long,
    @BsonId
    val id:String = ObjectId().toString()
)
