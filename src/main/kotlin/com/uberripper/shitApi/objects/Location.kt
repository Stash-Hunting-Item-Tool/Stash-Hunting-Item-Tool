package com.uberripper.shitApi.objects

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Location(
    var locX: Double = 0.0,
    var locY: Double = 0.0,
    var locAddress: String?
)