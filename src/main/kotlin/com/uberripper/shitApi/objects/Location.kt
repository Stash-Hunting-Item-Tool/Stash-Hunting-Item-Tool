package com.uberripper.shitApi.objects

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Location(
    var locX: Int = 0,
    var locY: Int = 0,
    var locAddress: String = "",
)