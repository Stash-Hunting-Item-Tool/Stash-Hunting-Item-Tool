package com.uberripper.shitApi.objects

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Items(
    @Id
    var id: String = ObjectId.get().toHexString(),
    var name: String = "",
    var comment: String = "",
    var qty: Int?,
    var location: Location? // null if the stash is gone. We're cheap on memory!
)